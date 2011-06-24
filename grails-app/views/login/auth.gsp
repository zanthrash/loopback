<head>
<meta name='layout' content='app' />
<title>Login</title>

<style type='text/css' media='screen'>

#login {
	margin:100px 0px; padding:0px;
	text-align:center;
}
#login .inner {
	width:685px;
	margin:0px auto;
	text-align:left;
	padding:10px;

    border:6px solid #2B251E;
	/*border-top:1px dashed #499ede;*/
	/*border-bottom:1px dashed #499ede;*/
	background-color:#EEF;
}
#login .inner .fheader {
	padding:4px;margin:3px 0px 3px 0;color:#2e3741;font-size:14px;font-weight:bold;
}
#login .inner .cssform p {
	clear: left;
	margin: 0;
	padding: 8px 0 8px 0;
	padding-left: 105px;
	border-top: 1px dashed gray;
	margin: 2px;
	height: 1%;
}
#login .inner .cssform input[type='text'] {
	width: 120px;
}
#login .inner .cssform label {
	font-weight: bold;
	float: left;
	margin-left: -105px;
	width: 100px;
}
#login .inner .login_message {color:red;}
#login .inner .text_ {width:120px;}
#login .inner .chk {height:12px;}
#login_button, #attend_button {
    margin-left:90px;
    width:100px;
}
#attend_button {
	float: right;
}
.clearboth { clear: both;}
#login #left {
	padding-right:30px;
	border-right: 6px solid #2B251E;
}
#login #right {
	float:right;
	padding: 0px 10px 0px 0px;

}
</style>
    <g:javascript src="login.js" />
</head>

<body>
	<div id='login'>
		<div class='inner'>
			<g:if test='${flash.message}'>
			<div class='login_message'>${flash.message}</div>
			</g:if>
			<div id="left">
				<div class='fheader'>Login</div>
				<form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
					<p>
						<label for='username'>Login ID</label>
						<input type='text' class='text_' name='j_username' id='username'/>
					</p>

					<p>
						<label for='password'>Password</label>
						<input type='password' class='text_' name='j_password' id='password'/>
					</p>

					<p>
						<label for='remember_me'>Remember me</label>
						<input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me'
								 <g:if test='${hasCookie}'>checked='checked'</g:if>/>
					</p>

					<p>
						<input id="login_button" type='submit' value='Login'/>
					</p>
				</form>
			</div>
			<div id="right">
				<div class='fheader'>Attend</div>
				<g:form controller="comment" action="post" class='cssform'>
				<p>
					<label for="accessCode">Access Code:</label>
					<g:textField name="accessCode"/>
				</p>


				<p>
					<input id="attend_button" type='submit' value='Attend'/>
				</p>
				</g:form>
			</div>
			<div class='clearboth'> </div>

		</div>
	</div>
<script type='text/javascript'>
<!--
(function(){
	document.forms['loginForm'].elements['j_username'].focus();
})();
// -->
</script>
</body>
