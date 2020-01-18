$(function(){
    $('#send1').click(function(){
        var temp=$('form').serializeArray();
        var messageId=$.param(temp);
    	// alert('ok');
        location.href='HomeSendMS?'+messageId;
    });
});