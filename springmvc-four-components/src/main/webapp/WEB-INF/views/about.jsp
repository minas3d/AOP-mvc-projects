<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>

<h1>/about</h1>

<p>
  There is no Java behind this URL. The handler is a
  <b>ParameterizableViewController</b>, configured entirely in
  dispatcher-servlet.xml with a single viewName property.
</p>

<p><a href="<%= request.getContextPath() %>/">index</a></p>

</body>
</html>
