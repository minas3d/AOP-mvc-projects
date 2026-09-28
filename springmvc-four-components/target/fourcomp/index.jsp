<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>

<h1>Spring MVC - the four components</h1>

<p>
  One DispatcherServlet, one XML file. Every strategy bean is declared by hand
  in /WEB-INF/dispatcher-servlet.xml - that file is the thing to read.
</p>

<ul>
  <li><a href="diagnostics">/diagnostics</a> - the three strategy lists, in order. Start here.</li>
  <li><a href="home">/home</a> - AbstractController, SimpleControllerHandlerAdapter, JSP</li>
  <li><a href="about">/about</a> - ParameterizableViewController, no Java at all</li>
  <li><a href="legacy">/legacy</a> - Controller interface, routed by BeanNameUrlHandlerMapping</li>
  <li><a href="annotated">/annotated</a> - @Controller, RequestMappingHandlerAdapter</li>
  <li><a href="raw">/raw</a> - HttpRequestHandler, no model and no view</li>
  <li><a href="greet">/greet</a> - our own handler type, invoked by our own adapter</li>
  <li><a href="plain">/plain</a> - BeanNameViewResolver finds a View bean instead of a JSP</li>
  <li><a href="go-home">/go-home</a> - view name resolves to a RedirectView, sends a 302</li>
</ul>

</body>
</html>
