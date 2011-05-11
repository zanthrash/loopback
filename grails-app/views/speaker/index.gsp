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
     <title>${speaker.fullName} Presentations</title>
  </head>
  <body>

  <div id="main">
      <g:if test="${flash.message}">
          <p>${flash.message}</p>
      </g:if>

      <div id="presentation_list">
          <g:each in="${presentations}" var="presentationList">
              ${presentationList.key}
              <g:each in="${presentationList.value.sort{it.date}}" var="presentation">
                  <p>
                      <span id="presentation_date"><g:formatDate date="${presentation.date}" format="MMM d"/></span>
                      <span id="presentation_link"><g:link controller="presentation" action="show" id="${presentation.id}">${presentation.title}</g:link></span>
                  </p>
              </g:each>
          </g:each>
      </div>
  </div>
  <div id="sidebar">
      <div id="add_form">
          <h3>Add another presentation</h3>
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