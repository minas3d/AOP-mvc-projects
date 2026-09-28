<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="base" value="${pageContext.request.contextPath}/task" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Taskboard - Task not saved</title>
    <%@ include file="fragments/head.jspf" %>
</head>
<body>
<div class="wrap">
    <%@ include file="fragments/nav.jspf" %>

    <main>
        <h1>Couldn't save the task</h1>

        <div class="panel p-high">
            <div class="tab"><span>Not saved</span></div>
            <div class="inner">
                <p class="lead">Something went wrong while saving.</p>
                <p>Check that the ID and title are filled in, then try again.</p>
                <div class="actions">
                    <a class="btn" href="${base}/new">Back to the form</a>
                    <a class="btn ghost" href="${base}/showAll">All tasks</a>
                </div>
            </div>
        </div>
    </main>
</div>
</body>
</html>