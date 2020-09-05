<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>text-display</title>
    <link rel="stylesheet" href="">
</head>
<body>
<section class="main-container">
    <h1>Text</h1>
    <form action="${pageContext.request.contextPath}/users" method="post">
    <label>
        <textarea class="enteredText" name="text" contenteditable="true" autocomplete="on">
            ${sessionScope.savedText}
        </textarea>
    </label>
        <input type="hidden" value="${sessionScope.savedText.id}">
    <div class="buttons">
        <%--<input type="hidden" name="command" value="">--%>
        <div class="previousBtn">
            <input type="button" value="Previous">
        </div>

        <div class="nextBtn">
            <input type="button" value="Next">
        </div>

            <input type="hidden" name="command" value="command_analysis">
            <div class="saveBtn">

            </div>
            <input type="submit" name="text" value="Save">
        </form>


        <div class="clearBtn">
            <a href=${pageContext.request.contextPath}"/pages/text.jsp">Clear</a>
        </div>


    <form action="${pageContext.request.contextPath}/users" method="get">
        <button type="submit" value="next" name="nxt">Next</button>
        <input type="hidden" name="command" value="next_command">
    </form>


    <form action="${pageContext.request.contextPath}/users" method="get">
        <button type="submit" value="previous" name="prev">Previous</button>
        <input type="hidden" name="command" value="previous_command">
    </form>

       <%--<form action="${pageContext.request.contextPath}/users" method="post">--%>
        <%--<input type="hidden" name="command" value="command_analysis">--%>
           <%--<div class="analysisBtn">--%>
            <%--<input type="submit" name="analysis" value="Analysis">--%>
        <%--</div>--%>
    <%--</form>--%>
    </div>

</section>
</body>
</html>