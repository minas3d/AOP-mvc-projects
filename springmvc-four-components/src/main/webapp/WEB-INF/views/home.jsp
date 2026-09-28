<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>

<h1>/home</h1>

<p>Handler shape: <b>${shape}</b></p>
<p>${note}</p>

<p>
  The controller returned the string "home". It never named a file.
  InternalResourceViewResolver turned that into /WEB-INF/views/home.jsp.
</p>

<p><a href="<%= request.getContextPath() %>/">index</a></p>

</body>
</html>
