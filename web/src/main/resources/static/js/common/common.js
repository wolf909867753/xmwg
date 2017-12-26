var common = {

    //验证手机号码
    isMobile : function($mobile){
        var mobilePattern = /^[1][3,4,5,7,8][0-9]{9}$/;
        if (!mobilePattern.test($mobile)) {
            return false;
        } else {
            return true;
        }
    },
    //验证密码  此规则只能是数字和字母的组合
    ispwd :function ($pwd) {
        var pwdPattern = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;
        if (!pwdPattern.test($pwd)) {
            return false;
        } else {
            return true;
        }
    }
    
}