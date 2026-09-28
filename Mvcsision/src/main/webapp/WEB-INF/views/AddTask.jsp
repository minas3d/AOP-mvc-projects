<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="base" value="${pageContext.request.contextPath}/task" />
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Taskboard - Add task</title>
    <%@ include file="fragments/head.jspf" %>
</head>
<body>
<div class="wrap">
    <%@ include file="fragments/nav.jspf" %>

    <main>
        <h1>Add a task</h1>

        <div class="panel">
            <div class="tab"><span>New task</span></div>
            <div class="inner">
                <form action="${base}/setData" method="post" autocomplete="off">
                    <div class="field">
                        <label for="id">Task ID</label>
                        <input type="text" id="id" name="id" placeholder="e.g. 6" required>
                    </div>

                    <div class="field">
                        <label for="title">Title</label>
                        <input type="text" id="title" name="title" placeholder="What needs doing?" required>
                    </div>

                    <fieldset>
                        <legend class="legend">Priority</legend>
                        <div class="choices">
                            <input type="radio" id="p-high" name="priority" value="High">
                            <label class="high" for="p-high"><span class="dot high"></span>High</label>

                            <input type="radio" id="p-medium" name="priority" value="Medium" checked>
                            <label class="medium" for="p-medium"><span class="dot medium"></span>Medium</label>

                            <input type="radio" id="p-low" name="priority" value="Low">
                            <label class="low" for="p-low"><span class="dot low"></span>Low</label>
                        </div>
                    </fieldset>

                    <div class="actions">
                        <button class="btn" type="submit">Save task</button>
                        <a class="btn ghost" href="${base}/showAll">Cancel</a>
                    </div>
                </form>
            </div>
        </div>
    </main>
</div>
</body>
</html>
