package com.myq.springbootjdbc.service.impl;

import com.myq.springbootjdbc.dao.UserDao;
import com.myq.springbootjdbc.pojo.User;
import com.myq.springbootjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户管理业务层
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 预更新
     * @param userid
     * @return
     */
    @Override
    public User findUserById(Integer userid) {
        return this.userDao.selectUserById(userid);
    }

    /**
     * 查询全部用户
     * @return
     */
    @Override
    public List<User> findUser() {
        return this.userDao.findUserAll();
    }

    /**
     * 添加用户
     * @param user
     */
    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.insertUser(user);
    }
}
