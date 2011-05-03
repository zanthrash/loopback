<!DOCTYPE html>
<html>
    <head>
        <title>
            <g:layoutTitle default="Loopback"/>
        </title>
        <g:javascript src="jquery/jquery-1.5.2.js" />
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Tangerine|Pacifico|Lobster|Cabin+Sketch:bold|Permanent+Marker|Inconsolata">
        <link href="${resource(dir:'css', file:'main.css')}" rel="stylesheet"/>
        <g:layoutHead />


    </head>
    <body>
        <div id="headerBar"></div>
        <div id="page">
            <div id="header">
                <g:render template="/layouts/header" />
            </div>

            <div id="content">
                <g:layoutBody />
            </div>

            %{--<div id="footer">--}%
                %{--<g:render template="/layouts/footer"/>--}%
            %{--</div>--}%
        </div>
    </body>
</html>