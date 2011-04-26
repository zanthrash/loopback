<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <meta name="layout" content="app">
      <title>Event: ${event.name}</title>
  </head>
  <body>
    <p>Event:${event.name}</p>
    <p>Presentations(s):</p>
    <ol>
        <g:each in="${event.presentations}" var="presentation">
            <li>
                <g:link controller="presentation" action="show" id="${presentation.id}">${presentation.title}</g:link>  by ${presentation.speakers*.fullName}
            </li>
        </g:each>
    </ol>
  </body>
</html>