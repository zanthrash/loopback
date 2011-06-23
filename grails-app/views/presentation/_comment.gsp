<div class="comment" id="comment_${comment.id}">
    <h2>${comment.text}</h2>
    <div class="commentInfo">
        <span class="comment_date"><g:formatDate date="${comment.dateCreated}" format="MMM dd, yyyy @ h:mm a" /> </span>
        <span class="comment_client">${comment.clientIPAddress}</span>
    </div>
</div>
