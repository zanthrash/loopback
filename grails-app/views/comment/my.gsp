<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<meta name="layout" content="app">
	<title>My Comment</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
	<g:javascript src="comment.js"/>
</head>

<body>
<content tag="header">
	<div id="userinfo">
		<g:link controller="comment" action="code" params="${[accessCode: presentation.accessCode]}">
			Post a new comment
		</g:link>
	</div>
</content>

<div id="main">
	<h1>Presentation:<br/> ${presentation.title}</h1>

	<g:comments comments="${myComments}">
		<g:comment comment="${comment}"/>
	</g:comments>

</div>

</body>
</html>