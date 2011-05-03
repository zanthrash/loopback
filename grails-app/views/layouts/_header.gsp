<g:link url="/loopback">
    <span id="header_text" >Loopback</span>
</g:link>
<div id="userinfo">
    <sec:ifLoggedIn>
        Howdy <sec:username/> | <g:link controller="logout">Logout</g:link>
    </sec:ifLoggedIn>
</div>
<g:pageProperty name="page.header"/>
