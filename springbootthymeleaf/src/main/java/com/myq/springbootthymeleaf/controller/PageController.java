package com.myq.springbootthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面跳转
 */
@Controller
public class PageController {
    /**
     * 页面跳转方法
     */
    @GetMapping("/show")
    public String showPage(Model model){
        model.addAttribute("msg","Thymeleaf");
        return "index";
    }
}
