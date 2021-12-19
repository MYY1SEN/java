package com.MYQ.dao;

import com.MYQ.pojo.users;

import java.util.List;

public interface UserManagerDao {
    void insertuser(users user);
    List<users> selectUserByProperty(users users);
    users selectUserByUserid(int userid);
    void updataUserByUserid(users users);
    void deleteUserByUserid(int userid);
}
