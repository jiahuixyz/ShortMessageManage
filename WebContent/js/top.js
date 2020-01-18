$(function(){
    var url1=location.href;
    if((url1.indexOf("home.jsp"))>-1){
        $('#navbar>ul>li:eq(0)').addClass('active');
    }
    if((url1.indexOf("homeHistory.jsp"))>-1){
        $('#navbar>ul>li:eq(2)').addClass('active');
    }
    if((url1.indexOf("homeSendMS.jsp"))>-1){
        $('#navbar>ul>li:eq(1)').addClass('active');
    }
    // if((url1.indexOf("homeHistory.jsp"))>-1){
    //     $('#navbar>ul>li:eq(1)').addClass('active');
    // }
});