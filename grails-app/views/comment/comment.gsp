
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <meta name="layout" content="app">
      <title>Enter Comment</title>
  </head>
  <body>
    <content tag="header">
        <h1>Enter Comment for: ${presentation.title}</h1>
    </content>

    <div id="main">
        <g:if test="${flash.message}">
            ${flash.message}
        </g:if>
        <g:form action="post" controller="comment">
            <label for="comment">Enter comment:</label>
            <g:hiddenField name="accessCode" value="${presentation.accessCode}" />
            <g:textField name="comment"/>
            <g:submitButton name="enter" value="Enter"/>
        </g:form>
    </div>

  </body>
</html>