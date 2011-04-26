<%--
  Created by IntelliJ IDEA.
  User: zanthrash
  Date: 4/25/11
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <meta content="app" name="layout">
     <title>Simple GSP page</title>
  </head>
  <body>
    <content tag="header">
        ${speaker.fullName}
    </content>

    <div id="main">
        <g:each in="${speaker.presentations}" var="presentation">
            <p><g:link controller="presentation" action="show" id="${presentation.id}"> ${presentation.title}</g:link></p>
        </g:each>
    </div>
  </body>
</html>