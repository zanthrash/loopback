<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <meta name="layout" content="app"/>
      <title>Manage Events</title>
  </head>
  <body>
    <ul>
    <g:each in="${events}" var="event">
       <ol>
          <g:link controller="event" action="show" id="${event.id}">${event.name}</g:link>
       </ol>
    </g:each>
    </ul>
  </body>
</html>