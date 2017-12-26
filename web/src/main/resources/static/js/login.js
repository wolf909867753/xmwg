$(function () {
    //设置登录框上下居中
    login.middle();
    //登录
    login.login();

    //清空错误提示信息
    login.cleanErrorMsg();

    common.ispwd()
});


var login = {
    middle : function(){
        $('.demo').css({'padding-top':($(window).height() - $('.demo').height())/2});
    },

    login : function(){
        $('#_btn').on('click',function(){
            var $mobile = $('#mobile').val(),$pwd = $('#pwd').val();
            if('' === $mobile){
                $('#mobile_error').text('手机号码不能为空');
                return false;
            }

            if(!common.isMobile($mobile)){
                $('#mobile_error').text('手机号码格式不正确');
                return false;
            }
            if('' === $pwd){
                $('#pwd_error').text('密码不能为空');
                return false;
            }

            if(!common.ispwd($pwd)){
                $('#pwd_error').text('密码为6~12位数字和字母组合');
                return false;
            }

            $(form).submit();
        });
    },
    cleanErrorMsg : function(){
        $('form  input').on('focus',function(){
            $('.error').text('');
        });
    }


}