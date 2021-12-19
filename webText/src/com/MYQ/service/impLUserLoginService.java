package com.MYQ.service;

import com.MYQ.dao.UserLoginDao;
import com.MYQ.dao.impL.UserLoginDaoImpL;
import com.MYQ.exception.UserNotFoundException;
import com.MYQ.pojo.users;
import com.MYQ.service.UserLoginService;

/**
 * 用户登录业务
 */
public class impLUserLoginService implements UserLoginService {
    /**
     * 用户登录
     * @param username
     * @param userpwd
     * @return
     */
    @Override
    public users userLogin(String username, String userpwd) {
        UserLoginDao userLoginDao = new UserLoginDaoImpL();
        users users = userLoginDao.selectUsersByUsernameandUserpwd(username, userpwd);
        if (users == null){
            throw new UserNotFoundException("用户名或密码有误");
        }
        return users;
    }
}
