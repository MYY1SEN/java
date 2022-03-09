package com.myq.dao;

import com.myq.pojo.Order;
import com.myq.pojo.User;

public interface UserDao {
    void insertUser(User user);
    void insertOrder(Order order);
}
