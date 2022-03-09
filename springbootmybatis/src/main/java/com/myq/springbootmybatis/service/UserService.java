package com.myq.springbootmybatis.service;

import com.myq.springbootmybatis.pojo.Users;

import java.util.List;

public interface UserService {
    void adduser(Users users);

    List<Users> findUser();

    Users preupdateuser(Integer id);

    void modifyuser(Users users);
}
