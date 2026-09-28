<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="base" value="${pageContext.request.contextPath}/task" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Taskboard - Task not found</title>
    <%@ include file="fragments/head.jspf" %>
</head>
<body>
<div class="wrap">
    <%@ include file="fragments/nav.jspf" %>

    <main>
        <h1><span class="n">404</span> Task not found</h1>

        <div class="panel p-high">
            <div class="tab"><span>No match</span></div>
            <div class="inner">
                <p class="lead"><c:out value="${message}"/></p>
                <p>Check the ID and try again, or open the full list and pick a task from there.</p>
                <div class="actions">
                    <a class="btn" href="${base}/showAll">Browse all tasks</a>
                    <a class="btn ghost" href="${base}/new">Add task</a>
                </div>
            </div>
        </div>
    </main>
</div>
</body>
</html>
