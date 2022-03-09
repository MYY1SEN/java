package com.myq.springbootjdbc.dao;

import com.myq.springbootjdbc.pojo.User;

import java.util.List;

public interface UserDao {
    void insertUser(User user);
    List<User> findUserAll();
    User selectUserById(Integer userid);
}
