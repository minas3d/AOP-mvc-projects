<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>

<h1>/greet</h1>

<p>${message}</p>
<p>Handler shape: <b>${shape}</b></p>

<p>
  GreetingHandler is an interface invented in this project. It is not a
  Controller, not an HttpRequestHandler, and has no annotations. It works
  because HandlerMapping returns the handler as Object, and we supplied a
  small HandlerAdapter that knows how to call it.
</p>

<p>
  Delete the GreetingHandlerAdapter bean and this URL fails with
  "No adapter for handler [...]".
</p>

<p>Try <a href="?name=Cairo">?name=Cairo</a>.</p>

<p><a href="<%= request.getContextPath() %>/">index</a></p>

</body>
</html>
