package com.myq.springbootjdbc.controller;

import com.myq.springbootjdbc.pojo.User;
import com.myq.springbootjdbc.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 添加用户
     *
     * @return
     */
    @PostMapping("/adduser")
    public String add(User user) {
        try {
            this.userService.addUser(user);
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
        List<User> list = null;
        try {
            list = this.userService.findUser();
            model.addAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "showusers";
    }

    /**
     * 预更新用户
     */
    @GetMapping("/preupdateuser")
    public String preupdateuser(Integer userid, Model model){
        try {
            User user = this.userService.findUserById(userid);
            model.addAttribute("user",user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "updateuser";
    }
}
