<!DOCTYPE html>
<html>
    <head>
        <title>
            <g:layoutTitle default="Loopback"/>
        </title>
        <g:layoutHead />
        <link href="${resource(dir:'css', file:'main.css')}" rel="stylesheet"/>

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