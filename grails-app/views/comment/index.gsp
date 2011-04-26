
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <meta name="layout" content="app">
      <title>Presentation Access Code</title>
  </head>
  <body>
    <content tag="header">
        <h1>Access Code</h1>
    </content>

    <div id="main">
        <g:form action="code" controller="comment">
            <label for="code">Enter Code:</label>
            <g:textField name="code"/>
            <g:submitButton name="enter" value="Enter"/>
        </g:form>
    </div>

  </body>
</html>