package com.xmwg.wq.config;

import com.xmwg.wq.wechat.utils.TokenThread;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微信config
 */
@Configuration
public class WechatConfig {

    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.appsecret}")
    private String appsecret;

    //获取token
    @Bean
    public String initTokenThread(){
        TokenThread.appid = appId;
        TokenThread.appsecret = appsecret;
        new Thread(new TokenThread()).start();
        return null;
    }
}
