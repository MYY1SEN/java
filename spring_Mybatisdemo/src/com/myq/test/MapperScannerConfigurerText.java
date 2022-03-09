package com.myq.test;

import com.myq.pojo.Users;
import com.myq.service.userService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MapperScannerConfigurerText {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
        userService userService = (userService) applicationContext.getBean("userService");
        List<Users> usersAll = userService.findUsersAll();
        usersAll.forEach(System.out::println);
    }
}
