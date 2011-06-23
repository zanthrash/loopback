$(document).ready(function(){
    var resultsChannel = $("#commentBox").attr('data-channel');
    var channels = [ resultsChannel ];

    var testCallback = function(message) {
    };

    var resultsCallback = function(message) {
        var obj = $.parseJSON(message.data);
        updateChatComment(message.data);
    };

    var searchResultsCallback = function(message) {
//        alert("search results: " + message.data);
    }

    var callbackFunctions = {
        '/test' : testCallback,
        '/request/search' : searchResultsCallback
    };
    callbackFunctions[resultsChannel] = resultsCallback

    var protocol = document.location.protocol
    var host = document.location.host
    var pathname = document.location.pathname
    var cometdpathname = pathname.replace(/^((?:[//]+[\w-]*){1})([//]+[\w*]*).*$/, "$1/cometd");

    $.cometd.configure({
        url:new String(protocol + "//" + host + cometdpathname)
//        maxNetworkDelay:15000,
//        logLevel:"debug"
    });
    $.cometd.handshake();
    $.cometd.addListener('/meta/connect', function(message) {
        if ($.cometd.isDisconnected()) {
            return;
        }
        if (message.successful) {
//            $.cometd.publish('/test', {'data': {'message':"Connection with CommetD server has been established." } });
//            $.cometd.publish('/request/search', { 'payload': { deal: 1, params: { offset: 10 } } });
        }
    });
    refreshComentSubsriptions(channels, callbackFunctions)
});


function updateChatComment(jsonMessage) {
    var json = $.parseJSON(jsonMessage)

    $("#commentBox > div:first-child").before(json.commentHtml);
    $("#comment_count").html(json.commentCountHtml);

}