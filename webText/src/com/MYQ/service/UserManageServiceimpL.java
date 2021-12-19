package com.MYQ.service;

import com.MYQ.dao.UserManagerDao;
import com.MYQ.dao.impL.UserManagerDaoimpL;
import com.MYQ.pojo.users;

import java.util.List;

/**
 * 用户管理业务层
 */
public class UserManageServiceimpL implements UserManageService{
    /**
     * 添加用户
     * @param user
     */
    @Override
    public void adduser(users user) {
        UserManagerDao userManagerDao = new UserManagerDaoimpL();
        userManagerDao.insertuser(user);
    }

    /**
     * 查询用户
     * @param users
     * @return
     */
    @Override
    public List<users> findUsers(users users) {
        UserManagerDao userManagerDao = new UserManagerDaoimpL();
        return userManagerDao.selectUserByProperty(users);
    }

    /**
     * 通过用户id查询
     * @param userid
     * @return
     */
    @Override
    public users findUserByUserid(int userid) {
        UserManagerDao userManagerDao = new UserManagerDaoimpL();
        return userManagerDao.selectUserByUserid(userid);
    }

    /**
     * 修改用户
     * @param users
     */
    @Override
    public void modifyUsers(users users) {
        UserManagerDao userManagerDao = new UserManagerDaoimpL();
        userManagerDao.updataUserByUserid(users);
    }

    /**
     * 根据用户id删除
     * @param userid
     */
    @Override
    public void jropUsers(int userid) {
        UserManagerDao userManagerDao = new UserManagerDaoimpL();
        userManagerDao.deleteUserByUserid(userid);
    }
}
