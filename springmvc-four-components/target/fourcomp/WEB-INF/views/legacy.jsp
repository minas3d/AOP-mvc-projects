<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>

<h1>/legacy</h1>

<p>Handler shape: <b>${shape}</b></p>
<p>times = ${times}</p>
<p>echo  = ${echo}</p>

<p>
  Routed by BeanNameUrlHandlerMapping: the bean is declared as
  name="/legacy", so the bean name is the URL.
</p>

<p>
  Try <a href="?times=6">?times=6</a> and <a href="?times=banana">?times=banana</a>.
  The parsing and defaulting are hand-written in the controller, because
  SimpleControllerHandlerAdapter does none of that for you.
</p>

<p><a href="<%= request.getContextPath() %>/">index</a></p>

</body>
</html>
