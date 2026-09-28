<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<c:set var="base" value="${pageContext.request.contextPath}/task" />
<c:set var="sel" value="${fn:toLowerCase(param.priority)}" />
<c:set var="total" value="${fn:length(tasks)}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Taskboard - All tasks</title>
    <%@ include file="fragments/head.jspf" %>
</head>
<body>
<div class="wrap">
    <%@ include file="fragments/nav.jspf" %>

    <main>
        <h1><span class="n">${total}</span> ${total == 1 ? 'task' : 'tasks'} on the board</h1>

        <div class="tools">
            <div class="chips" role="group" aria-label="Filter by priority">
                <a class="chip" href="${base}/showAll" ${empty sel ? 'aria-current="true"' : ''}>All</a>
                <a class="chip" href="${base}/showByPriority?priority=High" ${sel eq 'high' ? 'aria-current="true"' : ''}><span class="dot high"></span>High</a>
                <a class="chip" href="${base}/showByPriority?priority=Medium" ${sel eq 'medium' ? 'aria-current="true"' : ''}><span class="dot medium"></span>Medium</a>
                <a class="chip" href="${base}/showByPriority?priority=Low" ${sel eq 'low' ? 'aria-current="true"' : ''}><span class="dot low"></span>Low</a>
            </div>

            <form class="find" id="findForm" role="search">
                <input type="text" name="id" placeholder="Task ID, e.g. 3" aria-label="Task ID" autocomplete="off">
                <button class="btn" type="submit">Open task</button>
            </form>
        </div>

        <c:choose>
            <c:when test="${total == 0}">
                <div class="panel">
                    <div class="inner">
                        <h2 class="headline">No tasks to show</h2>
                        <p class="lead">Try another priority, or add a task to get the board moving.</p>
                        <div class="actions">
                            <a class="btn" href="${base}/new">Add task</a>
                            <a class="btn ghost" href="${base}/showAll">Show all tasks</a>
                        </div>
                    </div>
                </div>
            </c:when>

            <c:otherwise>
                <ul class="grid">
                    <c:forEach var="t" items="${tasks}" varStatus="st">
                        <li>
                            <a class="card p-${fn:toLowerCase(t.priority)}" style="--i:${st.index}" href="${base}/showById/${t.id}">
                                <span class="tab"><span><c:out value="${t.priority}"/> priority</span></span>
                                <div class="body">
                                    <h2 class="title"><c:out value="${t.title}"/></h2>
                                </div>
                                <span class="foot">
                  <span class="id">#<c:out value="${t.id}"/></span>
                  <span class="open">Open details</span>
                </span>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </c:otherwise>
        </c:choose>
    </main>
</div>

<script>
    document.getElementById('findForm').addEventListener('submit', function (e) {
        e.preventDefault();
        var id = this.elements.id.value.trim();
        if (id) {
            window.location = '${base}/showById/' + encodeURIComponent(id);
        }
    });
</script>
</body>
</html>
