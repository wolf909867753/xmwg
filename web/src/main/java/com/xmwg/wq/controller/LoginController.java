package com.xmwg.wq.controller;

import com.xmwg.wq.utils.ValidationUtils;
import com.xmwg.wq.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * 登出controller
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/toLogin")
    public String toLogin(){
        if(logger.isInfoEnabled()){
            logger.info("============>跳转到登录页面");
        }
        return "login";
    }
    /**
     * 登录
     * @param userVo
     * @param result
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String index(@Valid UserVo userVo, BindingResult result,Model model){
        if(logger.isInfoEnabled()){
            logger.info("============>登录");
        }
        if(result.hasErrors()){
            model.addAttribute("userVo",userVo);
            ValidationUtils.validate(result,model);
            return "login";
        }
        return "redirect:/index";
    }
}
