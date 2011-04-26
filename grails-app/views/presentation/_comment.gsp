
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="commentBox" id="comment_${comment.id}">
    <h1>${comment.text}</h1>
    <div class="commentInfo">
        <p>${comment.dateCreated}</p>
        <p>${comment.clientIPAddress}</p>
    </div>
</div>
