<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="app"/>
        <title>${presentation.title}</title>
    </head>
    <body>
        <content tag="header">
            <h1>${presentation.title}</h1>
        </content>
        <div id="main">
            <div id="commentBox">
                <g:each in="${presentation.comments}" var="comment">
                    <g:render template="comment" model="['comment':comment]"/>
                </g:each>
            </div>
        </div>

        <div id="sidebar">
            <div id="accessCode">
                Access Code:${presentation.accessCode}
            </div>
            <div>
                <p>${commentCount.size()} commenters</p>
                <g:each in="${commentCount}" var="count">
                    ${count.key} : ${count.value}
                </g:each>

            </div>
        </div>
    </body>
</html>