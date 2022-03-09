package com.myq.springbootmybatis.controller;

import com.myq.springbootmybatis.pojo.Users;
import com.myq.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 用户管理controller
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 添加用户
     */
    @PostMapping("/adduser")
    public String addUser(Users users) {
        try {
            this.userService.adduser(users);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/ok";
    }

    /**
     * 查询用户
     */
    @GetMapping("/finduser")
    public String findUser(Model model) {
        try {
            List<Users> list = this.userService.findUser();
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "showusers";
    }

    /**
     * 预更新用户查询
     */
    @GetMapping("preupdateuser")
    public String preupdateuser(Integer id, Model model) {
        try {
            Users user = this.userService.preupdateuser(id);
            model.addAttribute("user", user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "updateuser";
    }

    /**
     * 更新用户
     */
    @PostMapping("/updateuser")
    public String updateUser(Users users) {
        try {
            this.userService.modifyuser(users);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/ok";
    }
}
