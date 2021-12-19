package com.MYQ.service;

import com.MYQ.pojo.users;

/**
 * 用户登录业务层
 */
public interface UserLoginService {
    public users userLogin(String username,String userpwd);
}
