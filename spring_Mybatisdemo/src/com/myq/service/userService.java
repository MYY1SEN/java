package com.myq.service;

import com.myq.pojo.Users;

import java.util.List;

public interface userService {
    void addUser(Users users);
    List<Users> findUsersAll();
}
