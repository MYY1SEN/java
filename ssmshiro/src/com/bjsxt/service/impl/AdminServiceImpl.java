package com.bjsxt.service.impl;

import com.bjsxt.mapper.AdminMapper;
import com.bjsxt.pojo.Admin;
import com.bjsxt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("admins")
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper  adminMapper;

    @Override
    public Admin login(String uname, String pwd) {

        return adminMapper.selectOne(uname, pwd);
    }

    @Override
    public Admin findPwd(String username) {
        return adminMapper.selectPwd(username);
    }
}
