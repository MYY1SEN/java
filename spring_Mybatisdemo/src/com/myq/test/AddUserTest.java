package com.myq.test;

import com.myq.pojo.Users;
import com.myq.service.userService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddUserTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService userService = (userService) applicationContext.getBean("userService");
        Users users = new Users();
        users.setUsername("qianyema");
        users.setUsersex("male");
        userService.addUser(users);
    }
}
