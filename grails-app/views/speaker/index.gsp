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

  <div id="main">
      <g:if test="${flash.message}">
          <p>${flash.message}</p>
      </g:if>
      <g:each in="${speaker.presentations}" var="presentation">
          <p><g:link controller="presentation" action="show" id="${presentation.id}">${presentation.title} ${presentation.event.name}</g:link></p>
      </g:each>
  </div>
  <div id="sidebar">
      <div id="add_form">
          <g:form controller="presentation" action="add">

              <label for="eventName">Event:</label> <g:textField name="eventName"/><br/>
              <label for="title">Title:</label> <g:textField name="title"/><br>
              <label for="date">Date:</label><g:datePicker name="date" precision="day"/><br>
              <g:submitButton name="submit" value="Submit"/><br>
          </g:form>
      </div>
  </div>
  </body>
</html>