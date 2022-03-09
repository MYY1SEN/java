package com.myq.test;

import com.myq.pojo.Order;
import com.myq.pojo.User;
import com.myq.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext-tx.xml", "applicationContext.xml"});
        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = new User();
        user.setUsername("新二");
        user.setUsersex("male");
        Order order = new Order();
        order.setOrderprice(1080);
        userService.addUserAndOrder(user, order);
    }
}
