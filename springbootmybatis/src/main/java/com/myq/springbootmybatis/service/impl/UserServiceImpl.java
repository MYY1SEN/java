package com.myq.springbootmybatis.service.impl;

import com.myq.springbootmybatis.mapper.UsersMapper;
import com.myq.springbootmybatis.pojo.Users;
import com.myq.springbootmybatis.pojo.UsersExample;
import com.myq.springbootmybatis.service.UserService;
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
    private UsersMapper usersMapper;

    /**
     * 更新用户
     *
     * @param users
     */
    @Override
    @Transactional
    public void modifyuser(Users users) {
        this.usersMapper.updateByPrimaryKey(users);
    }

    /**
     * 预更新用户查询
     *
     * @param id
     * @return
     */
    @Override
    public Users preupdateuser(Integer id) {
        return this.usersMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询用户
     *
     * @return
     */
    @Override
    public List<Users> findUser() {
        UsersExample usersExample = new UsersExample();
        return this.usersMapper.selectByExample(usersExample);
    }

    /**
     * 添加用户
     *
     * @param users
     */
    @Override
    @Transactional
    public void adduser(Users users) {
        this.usersMapper.insert(users);
    }
}
