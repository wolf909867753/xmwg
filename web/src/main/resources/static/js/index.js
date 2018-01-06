$(function () {
    //轮播图
    index.lbt();

});


var index = {
    lbt : function(){
        $('#circleContent').carousel({interval:3000});//每隔5秒自动轮播
    }
}