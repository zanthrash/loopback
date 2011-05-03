<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="app"/>
        <title>${presentation.title}</title>
    </head>
    <body>
        <content tag="header">
        </content>
        <div id="main">
            <h1>${presentation.title}</h1>
            <div id="commentBox">
                <g:each in="${comments}" var="comment">
                    <g:render template="comment" model="['comment':comment]"/>
                </g:each>
            </div>
        </div>

        <div id="sidebar">
            <div id="accessCode">
                Access Code:${presentation.accessCode}
            </div>
            <div id="comment_count">
                <p>${commentCount.size()} commenter<g:if test="${commentCount.size() > 1}">s</g:if></p>
                <g:each in="${commentCount}" var="count">
                    <h3>${count.key.padRight(20, '.')}  ${count.value} post<g:if test="${count.value > 1}">s</g:if></h3>
                </g:each>

            </div>
        </div>
    </body>
</html>