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
					<g:comments comments="${comments}">
						<g:comment comment="${comment}"/>
					</g:comments>
            </div>
        </div>

        <div id="sidebar">
            <div id="accessCode">
                Access Code:${presentation.accessCode}
            </div>

            <g:link controller="speaker" action="index">My Presentations</g:link>

            <div id="comment_count">
                <p>${commentCount.size()} commenter<g:if test="${commentCount.size() > 1}">s</g:if></p>
                <g:each in="${commentCount}" var="count">
                    <h3><g:fixedWidthIp ip="${count.key}" width="20" pad="."/>  ${count.value} post<g:if test="${count.value > 1}">s</g:if></h3>
                </g:each>

            </div>
        </div>
    </body>
</html>