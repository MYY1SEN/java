package com.bjsxt.controller;

import com.bjsxt.pojo.Admin;
import com.bjsxt.service.AdminService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.lang.model.element.UnknownAnnotationValueException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {



    @RequestMapping("login")
    public    String   login(HttpServletRequest req){

        //查看具体的异常信息，获得一场的信息名称
        Object ex = req.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);


        if(UnknownAccountException.class.getName().equals(ex)){

            req.setAttribute("msg","用户名错误");
        }else  if(IncorrectCredentialsException.class.getName().equals(ex)){

            req.setAttribute("msg","凭证不正确");

        }else{
            req.setAttribute("msg","未知异常");

        }

        return   "/error.jsp";

    }



}
