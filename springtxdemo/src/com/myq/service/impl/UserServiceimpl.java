package com.myq.service.impl;

import com.myq.dao.UserDao;
import com.myq.pojo.Order;
import com.myq.pojo.User;
import com.myq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceimpl implements UserService {
    @Autowired
    private UserDao userDao;

//    public UserDao getUserDao() {
//        return userDao;
//    }
//
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    /**
     * 添加用户与定单
     * @param user
     * @param order
     */
    @Override
    public void addUserAndOrder(User user, Order order) {
        this.userDao.insertOrder(order);
        this.userDao.insertUser(user);
    }
}
