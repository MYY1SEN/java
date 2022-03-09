package com.myq.springbootjdbc.service;

import com.myq.springbootjdbc.pojo.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> findUser();
    User findUserById(Integer userid);
}
