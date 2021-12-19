package com.MYQ.service;

import com.MYQ.pojo.users;

import java.util.List;

public interface UserManageService {
    void adduser(users user);
    List<users> findUsers(users users);
    users findUserByUserid(int userid);
    void modifyUsers(users users);
    void jropUsers(int userid);
}
