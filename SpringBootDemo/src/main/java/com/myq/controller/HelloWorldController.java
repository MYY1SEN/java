package com.myq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理请求controller
 */
@RestController //@controller和@ResponsBody 直接返回字符串
public class HelloWorldController {
    @RequestMapping("/hello")
    public String showHelloWorld(){
        return "Hello World";
    }
}
