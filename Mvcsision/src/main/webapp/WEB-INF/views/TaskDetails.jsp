<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<c:set var="base" value="${pageContext.request.contextPath}/task" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title><c:out value="${task.title}"/> - Taskboard</title>
    <%@ include file="fragments/head.jspf" %>
</head>
<body>
<div class="wrap">
    <%@ include file="fragments/nav.jspf" %>

    <main>
        <div class="panel p-${fn:toLowerCase(task.priority)}" style="margin-top:2.5rem">
            <div class="tab">
                <span><c:out value="${task.priority}"/> priority</span>
                <span>#<c:out value="${task.id}"/></span>
            </div>
            <div class="inner">
                <h1 class="headline"><c:out value="${task.title}"/></h1>

                <dl class="meta">
                    <dt>Task ID</dt>
                    <dd><c:out value="${task.id}"/></dd>
                    <dt>Priority</dt>
                    <dd><c:out value="${task.priority}"/></dd>
                </dl>

                <div class="actions">
                    <a class="btn" href="${base}/showAll">Back to all tasks</a>
                    <a class="btn ghost" href="${base}/new">Add task</a>
                </div>
            </div>
        </div>
    </main>
</div>
</body>
</html>
