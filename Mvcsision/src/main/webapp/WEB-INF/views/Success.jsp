<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="base" value="${pageContext.request.contextPath}/task" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Taskboard - Task saved</title>
    <%@ include file="fragments/head.jspf" %>
</head>
<body>
<div class="wrap">
    <%@ include file="fragments/nav.jspf" %>

    <main>
        <h1>Task saved</h1>

        <div class="panel p-low">
            <div class="tab"><span>Done</span></div>
            <div class="inner">
                <p class="lead">Your task is on the board.</p>
                <p>You can open it from the list, or add another one.</p>
                <div class="actions">
                    <a class="btn" href="${base}/showAll">View all tasks</a>
                    <a class="btn ghost" href="${base}/new">Add another task</a>
                </div>
            </div>
        </div>
    </main>
</div>
</body>
</html>
