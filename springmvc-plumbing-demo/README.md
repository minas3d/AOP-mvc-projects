# Spring MVC — Plumbing Demo

A deliberately old-fashioned Spring MVC application whose only job is to make the
wiring visible. There is **no `@Controller`, no `@EnableWebMvc`, no component scan,
and no Spring Boot** anywhere. Every strategy object `DispatcherServlet` uses is a
bean you declared, with a name you chose, in a file you can point at.

It covers, in working code:

- the `ServletContext` vs the root **Application Context** vs the per-servlet **Web Application Context**
- `ContextLoaderListener`, and the two default config-file names
- **two** `DispatcherServlet`s sharing one root context
- `SimpleUrlHandlerMapping` → `AbstractController` → `SimpleControllerHandlerAdapter` → `InternalResourceViewResolver`
- a `HandlerInterceptor`, arriving where it really arrives: inside the `HandlerExecutionChain`

## Run it

```bash
mvn clean package cargo:run
```

Then open **<http://localhost:8080/mvcdemo/>**.

Tomcat 10.1 runs **embedded**, inside the Maven JVM — nothing to download or install
by hand. First run pulls the jars from Maven Central, so it needs a network.

If embedded mode misbehaves (Cargo's own docs warn that Tomcat's
`TomcatURLStreamHandlerFactory` can be awkward in-process), use the fallback:

```bash
mvn clean package cargo:run -P installed
```

That downloads a real Tomcat distribution into `target/`, unpacks it, and starts it
as a separate process. Slower, but it is a genuine Tomcat.

Requires **JDK 17+** and **Tomcat 10+** — Spring 6 uses `jakarta.servlet.*`, not
`javax.servlet.*`. Tomcat 9 will not work.

## The four pages

| URL | What it demonstrates |
| --- | --- |
| `/context-info` | **Start here.** Prints the `ServletContext`, both Spring contexts, their ids, their beans, and the parent/child rule as live booleans |
| `/hello` | `AbstractController` → `SimpleControllerHandlerAdapter` → JSP. Try `/hello?name=Cairo` |
| `/time` | A second handler on the same mapping bean — its URL exists only in XML |
| `/api/ping` | A **second** `DispatcherServlet`, own web context, same root context, no view resolution at all |

Keep an eye on the console. `LoggingInterceptor` prints `preHandle` / `postHandle` /
`afterCompletion` around every request, in exactly the positions the lifecycle diagram
shows.

## Read the files in this order

```
src/main/webapp/WEB-INF/
├── web.xml                        1. the listener + the two dispatchers
├── applicationContext.xml         2. the ROOT context (default file name)
├── mvc-dispatcher-servlet.xml     3. mapping, adapter, handlers, view resolver
└── api-dispatcher-servlet.xml     4. the second, separate web context
```

Each one is more comment than configuration. That is on purpose.

## The seven things this project is trying to prove

**1. Neither config file name is declared anywhere.**
`web.xml` has no `contextConfigLocation` at all. `ContextLoaderListener` falls back to
`/WEB-INF/applicationContext.xml`; `FrameworkServlet` builds
`/WEB-INF/<servlet-name>-servlet.xml` from the **servlet name**. Rename the servlet
`mvc-dispatcher` → `foo` and it will look for `foo-servlet.xml`.

**2. There is exactly one root context, and one web context per dispatcher.**
`/context-info` lists the `ServletContext` attribute keys. You will see the `.ROOT`
key once, and a `FrameworkServlet.CONTEXT.<name>` key **twice** — once per dispatcher.

**3. A child sees the parent; a parent never sees the child.**
On `/context-info`, `greetingService` is `containsLocalBean = false` but
`containsBean = true`. `getBean` checks the child, then delegates upward. There is no
downward lookup, which is why `rootContext.containsBean("helloController")` is `false`.

**4. Both dispatchers share one service instance.**
Compare the `greeting-xxxx` id on `/hello` with the one on `/api/ping`. Same object:
one root context, two web contexts.

**5. Declaring one strategy bean switches off *all* the defaults for that strategy.**
`initHandlerMappings()` asks *"are there any beans of type `HandlerMapping`?"* — not
*"is there one for this URL?"*. Because `SimpleUrlHandlerMapping` exists here,
`RequestMappingHandlerMapping` is never registered, so `@GetMapping` would be silently
ignored in this context. Same rule for `HandlerAdapter`, `ViewResolver` and the rest.

**6. A prefix-mapped servlet strips its own prefix.**
`api-dispatcher` is mapped to `/api/*`, and its mapping key is `"/ping"`, *not*
`"/api/ping"`. Write the full path and it will never match.

**7. Handlers know nothing about URLs or view technology.**
`TimeController` never mentions `/time`; the mapping bean owns that. It returns the
string `"time"` and never mentions JSP; the view resolver owns that.

## Things worth breaking

Each of these fails in an instructive way:

| Change | What happens, and why |
| --- | --- |
| Delete `applicationContext.xml` | Startup fails with `FileNotFoundException`. The default location is not optional once the listener is declared. |
| Remove the `<listener>` from `web.xml` | No root context. `greetingService` is unresolvable, so both dispatchers fail to start. Move the bean into each `-servlet.xml` and it works again — with **two** service instances. |
| Add `<property name="x" ref="helloController"/>` to a root bean | Startup fails. Proof that a parent cannot reach into a child. |
| Change `<url-pattern>/</url-pattern>` to `/*` | Every page 404s. The forward to the JSP comes straight back to `DispatcherServlet`. |
| Change the `/time` mapping key to `/clock` | Works immediately. `TimeController.java` is untouched. |
| Comment out the `handlerAdapter` bean | Nothing changes — `SimpleControllerHandlerAdapter` is one of the defaults, and it is the only `HandlerAdapter` bean, so removing it lets all three defaults load. |
| Return `false` from `LoggingInterceptor.preHandle` | Blank response. No handler runs, no view renders. |

## Turn on the logs

Add this to see Spring choose each strategy at startup and per request:

```bash
mvn cargo:run -Dcargo.jvmargs="-Dlogging.level.org.springframework.web=DEBUG"
```

Or, more reliably, drop a `logback.xml` or `simplelogger.properties` on the classpath.
The lines worth finding are the ones naming the mapping that matched and the adapter
that was selected.
