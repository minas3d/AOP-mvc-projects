<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<html>
<body>

<h1>/diagnostics</h1>

<p>
  The three strategy lists DispatcherServlet built at startup, in the order
  it consults them. First match wins in all three.
</p>

<h2>Seam 1 - HandlerMapping</h2>
<ul>
<% for (Object o : (List<?>) request.getAttribute("mappings")) { %>
  <li><%= o %></li>
<% } %>
</ul>

<h2>Seam 2 - HandlerAdapter</h2>
<ul>
<% for (Object o : (List<?>) request.getAttribute("adapters")) { %>
  <li><%= o %></li>
<% } %>
</ul>

<h2>Seam 4 - ViewResolver</h2>
<ul>
<% for (Object o : (List<?>) request.getAttribute("resolvers")) { %>
  <li><%= o %></li>
<% } %>
</ul>

<p>
  InternalResourceViewResolver is last on purpose. It never returns null,
  because any string concatenates into a path, so anything after it would
  be unreachable.
</p>

<p><a href="<%= request.getContextPath() %>/">index</a></p>

</body>
</html>
