package com.myq.springbootfreemarker.controller;

import com.myq.springbootfreemarker.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * usercontroller
 */
@Controller
public class UsersController {
    /**
     * 处理请求，返回数据
     */
    @GetMapping("/showuser")
    public String showUser(Model model){
        System.out.println(">>>>>>>");
        List<User> list = new ArrayList<>();
        list.add(new User("admin","F","20"));
        list.add(new User("admin2","F","20"));
        list.add(new User("admin3","F","20"));
        model.addAttribute("list",list);
        return "userList";
    }
}
