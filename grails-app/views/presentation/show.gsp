<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="app"/>
        <title>${presentation.title}</title>
        <g:javascript src="org/cometd.js" />
        <g:javascript src="jquery/jquery.cometd.js" />
        <g:javascript src="cometd-init.js" />
        <g:javascript src="cometd-subscriptions.js"/>
    </head>
    <body>
        <content tag="header">
        </content>
        <div id="main">
            <h1>${presentation.title}</h1>
            <div id="commentBox" data-channel="/comment/${presentation.id}">
                <g:each in="${comments}" var="comment">
                    <g:render template="comment" model="['comment':comment]"/>
                </g:each>
            </div>
        </div>

        <div id="sidebar">
            <div id="accessCode">
                Access Code:${presentation.accessCode}
            </div>

            <g:link controller="speaker" action="index">My Presentations</g:link>

            <div id="comment_count">
                <g:render template="commentCount" model="['commentCount':commentCount]" />
            </div>
        </div>
    </body>
</html>