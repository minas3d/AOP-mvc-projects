# Spring MVC — The Four Components, In Action

One `DispatcherServlet`. One XML file. Every strategy object declared by hand, so all
four seams are visible at once:

1. **`HandlerMapping`** — three of them, competing in one ordered chain
2. **`HandlerAdapter`** — four of them, including one written here
3. **The handler** — six different shapes, from `AbstractController` to a type Spring
   has never heard of
4. **`ViewResolver` → `View`** — two resolvers chained by order, plus a custom `View`

There is no `@EnableWebMvc`, no `<mvc:annotation-driven/>` and no component scan. Every
bean Spring would normally hide from you is written out in
`src/main/webapp/WEB-INF/dispatcher-servlet.xml` — that file is the real deliverable
here, and it is more comment than configuration on purpose.

## Run it

```bash
mvn clean package cargo:run
```

Then open **<http://localhost:8080/fourcomp/>**.

Tomcat 10.1 runs embedded, in the Maven JVM. If embedded mode misbehaves, use the
fallback that downloads a real Tomcat:

```bash
mvn clean package cargo:run -P installed
```

Needs **JDK 17+**. Spring 6 is `jakarta.*` only, so Tomcat 9 will not work.

## The routes

| URL | Handler shape | Mapping | Adapter | View step |
| --- | --- | --- | --- | --- |
| `/diagnostics` | `AbstractController` | `SimpleUrlHandlerMapping` | `SimpleControllerHandlerAdapter` | JSP |
| `/home` | `AbstractController` | `SimpleUrlHandlerMapping` | `SimpleControllerHandlerAdapter` | JSP |
| `/about` | `ParameterizableViewController` | `SimpleUrlHandlerMapping` | `SimpleControllerHandlerAdapter` | JSP |
| `/legacy` | `Controller` interface | **`BeanNameUrlHandlerMapping`** | `SimpleControllerHandlerAdapter` | JSP |
| `/annotated` | `@Controller` + `@GetMapping` | **`RequestMappingHandlerMapping`** | **`RequestMappingHandlerAdapter`** | JSP |
| `/raw` | `HttpRequestHandler` | `SimpleUrlHandlerMapping` | **`HttpRequestHandlerAdapter`** | none |
| `/greet` | **`GreetingHandler`** (ours) | `SimpleUrlHandlerMapping` | **`GreetingHandlerAdapter`** (ours) | JSP |
| `/plain` | `AbstractController` | `SimpleUrlHandlerMapping` | `SimpleControllerHandlerAdapter` | **`BeanNameViewResolver` → `PlainTextView`** |
| `/go-home` | `ParameterizableViewController` | `SimpleUrlHandlerMapping` | `SimpleControllerHandlerAdapter` | **`RedirectView`** → 302 |

Start at **`/diagnostics`**. It prints the three strategy lists in the exact order
`DispatcherServlet` consults them, read live out of the running context.

## The five things worth noticing

**1. The handler is `Object`, and that is the whole design.**
`/greet` is served by `GreetingHandler`, an interface invented in this project. It is
not a `Controller`, not an `HttpRequestHandler`, and carries no annotations. It works
because seam 1 returns the handler untyped and seam 2 is pluggable. Fifteen lines of
`GreetingHandlerAdapter` taught `DispatcherServlet` a handler type that did not exist
when `DispatcherServlet` was written.

**2. Two beans is most of what `@EnableWebMvc` does.**
`/annotated` works because `RequestMappingHandlerMapping` and
`RequestMappingHandlerAdapter` are declared explicitly. Note there is no component scan:
the mapping finds `@Controller` beans by inspecting every bean already in the context.

**3. Declaring one bean of a strategy type kills all the defaults for it.**
That is why all four adapters had to be listed. Delete `HttpRequestHandlerAdapter` and
`/raw` dies, even though it is one of Spring's own defaults.

**4. Order is everything, three times over.**
Mappings, adapters and resolvers are all "a list, sorted, first match wins".
`InternalResourceViewResolver` must be last, because it never returns `null`.

**5. One word changes the rendering technology.**
`HomeController` returns `"home"` and gets a JSP. `PlainController` is the identical
shape but returns `"plainTextView"` and gets a custom `View` bean. Neither controller
knows which happened.

## Things worth breaking

Each fails in an instructive way:

| Change | What happens |
| --- | --- |
| Delete the `GreetingHandlerAdapter` bean | `/greet` → `ServletException: No adapter for handler [...]`. Seam 1 still finds it; nothing can call it. |
| Set `InternalResourceViewResolver` order to `0` | `/plain` and `/go-home` break — the catch-all now answers first, so `BeanNameViewResolver` is never reached. |
| Give `BeanNameUrlHandlerMapping` order `-10`, add a bean named `/home` | The bean-name route wins. Ordering, not specificity, decides. |
| Delete `HttpRequestHandlerAdapter` | `/raw` breaks, because declaring any adapter disabled the defaults. |
| Delete the `RequestMappingHandlerAdapter` bean | `/annotated` breaks, everything else keeps working. |
| Add `defaultHandler` to `SimpleUrlHandlerMapping` | Unmapped URLs reach it instead of 404-ing. |
| Change `PlainController`'s view name to `"home"` | Same handler, same adapter, JSP instead of plain text. |
| Visit `/legacy?times=banana` vs `/annotated?answer=banana` | Hand-written try/catch versus a framework-produced 400. The difference is the adapter. |

## Where to look in the code

```
src/main/webapp/WEB-INF/
├── web.xml                    one DispatcherServlet, no root context
├── dispatcher-servlet.xml     ALL FOUR SEAMS — read this one
└── views/                     the JSPs

src/main/java/com/example/four/
├── handler/                   the six handler shapes
│   ├── HomeController.java        AbstractController
│   ├── LegacyController.java      Controller interface
│   ├── AnnotatedController.java   @Controller
│   ├── RawHandler.java            HttpRequestHandler
│   ├── GreetingHandler.java       our own handler type
│   ├── PlainController.java       same shape, different view name
│   └── DiagnosticsController.java lists the three strategy lists
├── adapter/GreetingHandlerAdapter.java    seam 2, written by us
└── view/PlainTextView.java                seam 4, written by us
```
