package com.myq.web.controller;

import com.myq.pojo.Uses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AnnContorller {
    //http://localhost:8888/springmvcdemo/ann
    @RequestMapping("/ann")
    public ModelAndView anndemo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("msg1", "Hello MYQ");
        return modelAndView;
    }

    /**
     * 通过HttpServletRequest对象获取请求参数
     * @return
     */
    @RequestMapping("/getData")
    public ModelAndView GetRequestParameter(HttpServletRequest httpServletRequest){
        String username = httpServletRequest.getParameter("name");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("username", username);
        return modelAndView;
    }
    @RequestMapping("/adduser")
    public ModelAndView adduser(Uses uses){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("uses", uses.toString());
        modelAndView.addObject("address", uses.getAddress().toString());
        return modelAndView;
    }
}
