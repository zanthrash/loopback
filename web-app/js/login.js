$(document).ready(function(){
    $('input[type="submit"]').click(function(){
        var accessCode = $('#accessCode').val()
        if(accessCode.length > 0) {
            $('form').attr('action', '/loopback/comment/code')
        }
        return true;
    })
});