
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <meta name="layout" content="app">
      <title>Enter Comment</title>
      <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
      <g:javascript src="comment.js"/>
  </head>
  <body>
    <content tag="header">
    </content>

    <div id="main">
        <h1>Presentation:<br /> ${presentation.title}</h1>

        <g:form action="post" controller="comment">
            <label for="comment">Tell me what you think:</label>
            <g:hiddenField name="accessCode" value="${presentation.accessCode}" />
            <g:textArea name="comment" style="width:100%;" cols="100" rows="15"/>
            <g:submitButton name="enter" value="Enter"/>
            <g:if test="${flash.message}">
                <span id="message">${flash.message}</span>
            </g:if>
        </g:form>

    </div>

  </body>
</html>