$(function () {
    $('#delete1').click(function () {
        var temp = $('form').serializeArray();
        var messageId = $.param(temp);
        location.href = 'DeleteMessage?' + messageId;
    });

    $('#forward1').click(function () {
        var temp = $('form').serializeArray();
        var messageId = $.param(temp);
        var result = new Array();
        $("input:checkbox").each(function () {
            if ($(this).is(":checked")) {
                result.push($(this).attr("value"));
            }
        });
        if (result.length == 1) {
            // console.log(result[0])
            location.href='/forwardSendMessage?messageId='+result[0];
        } else {
            alert("Only one mail can be forwarded at a time");
        }
    });
});