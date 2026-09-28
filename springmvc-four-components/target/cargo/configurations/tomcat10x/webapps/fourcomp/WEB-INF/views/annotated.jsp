<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>

<h1>/annotated</h1>

<p>Handler shape: <b>${shape}</b></p>
<p>answer = ${answer}</p>
<p>${note}</p>

<p>
  Try <a href="?answer=7">?answer=7</a> and <a href="?answer=banana">?answer=banana</a>.
  Compare with /legacy: here the framework produces a 400 instead of you
  writing a try/catch.
</p>

<p><a href="<%= request.getContextPath() %>/">index</a></p>

</body>
</html>
