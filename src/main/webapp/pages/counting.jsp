<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>text-display</title>
    <link rel="stylesheet" href="/statics/counting.css">
</head>
<body>
<section class="counters-container">
    <%--${sessionScope.count}--%>
    <div class="counters">
        <div class="correct-sentences">
            <h1>correct-sentences</h1>
            <label>
                <input value="${sessionScope.count.correctSentenceCount}">
            </label>
        </div>

        <div class="verbs">
            <h1>verbs</h1>
            <label>
                <input value="${sessionScope.count.verbCount}">
            </label>
        </div>

        <div class="nouns">
            <h1>nouns</h1>
            <label>
                <input value="${sessionScope.count.nounCount}">
            </label>
        </div>

        <div class="adjectives">
            <h1>adjectives</h1>
            <label>
                <input value="${sessionScope.count.adjectiveCount}">
            </label>
        </div>

        <div class="wrong-sentences">
            <h1>wrong-sentences</h1>
            <label>
                <input value="${sessionScope.count.incorrectSentenceCount}">
            </label>
        </div>
        <div class="back-button">
            <<a href="${pageContext.request.contextPath}/pages/text.jsp" type="bu">Back</a>
        </div>
    </div>
</section>
</body>
</html>