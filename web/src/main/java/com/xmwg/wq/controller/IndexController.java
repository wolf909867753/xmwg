package com.xmwg.wq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登出controller
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model){

        return "index";
    }
}
