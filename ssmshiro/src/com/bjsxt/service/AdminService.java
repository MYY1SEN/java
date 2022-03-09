package com.bjsxt.service;

import com.bjsxt.pojo.Admin;

public interface AdminService {

    //用户的登陆
    public Admin  login(String uname, String pwd);

    //获得用户密码 颜值操作
    public   Admin   findPwd(String   username);
}
