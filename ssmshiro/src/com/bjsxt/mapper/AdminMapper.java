package com.bjsxt.mapper;

import com.bjsxt.pojo.Admin;

public interface AdminMapper {

    //查询单个操作
    public Admin  selectOne(String uname, String pwd);


    public    Admin   selectPwd(String   username);

}
