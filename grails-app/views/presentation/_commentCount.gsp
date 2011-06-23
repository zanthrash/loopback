<p>${commentCount.size()} commenter<g:if test="${commentCount.size() > 1}">s</g:if></p>
<g:each in="${commentCount}" var="count">
    <h3><g:fixedWidthIp ip="${count.key}" width="20" pad="."/>  ${count.value} post<g:if
            test="${count.value > 1}">s</g:if></h3>
</g:each>
