package com.myq.service;

import com.myq.pojo.Order;
import com.myq.pojo.User;

public interface UserService {
    void addUserAndOrder(User user, Order order);
}
