package com.xmwg.wq.vo;

import org.hibernate.validator.constraints.NotBlank;

public class UserVo {

    @NotBlank(message = "手机号码不能为空")
    private String mobile;
    @NotBlank(message = "密码不能为空")
    private String password;
    //记住我
    private String rememberMe;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserVo{");
        sb.append("mobile='").append(mobile).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", rememberMe='").append(rememberMe).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
