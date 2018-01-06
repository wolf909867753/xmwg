package com.xmwg.wq.wechat.controller;

import com.xmwg.wq.utils.SignUtil;
import com.xmwg.wq.wechat.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RequestMapping("/wx")
@Controller
public class WechatController {

    @Autowired
    private WechatService wechatService;

    /**
     *核心请求处理类 确认请求来自微信服务器
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public void wechatAccessToken(HttpServletRequest request, HttpServletResponse response){
        PrintWriter out = null;
        try {
            // 微信加密签名  
            String signature =  request.getParameter("signature");
            // 时间戳  
            String timestamp = request.getParameter("timestamp");
            // 随机数  
            String nonce = request.getParameter("nonce");
            // 随机字符串  
            String echostr = request.getParameter("echostr");
            out = response.getWriter();
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
            if(SignUtil.checkSignature(signature,timestamp, nonce)){
                out.print(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
            out = null;
        }
    }

    /**
     * 处理微信服务器发来的消息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public void invokeWechatCallBackMethod(HttpServletRequest request, HttpServletResponse response){
        PrintWriter out = null;
        try {
            // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            // 调用核心业务类接收消息、处理消息
            String respMessage = wechatService.processRequest(request);

            // 响应消息
            out = response.getWriter();
            out.print(respMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }
    }
}
