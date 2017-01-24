$(function(){
    $('#messages li').click(function(){
        $(this).fadeOut();
    });
    $('#messages li').innerHTML="sssss";


    setTimeout(function(){
        $('#messages li.info').fadeOut();
    }, 2000);
});