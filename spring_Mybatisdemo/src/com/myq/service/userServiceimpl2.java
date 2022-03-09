package com.myq.service;

import com.myq.mapper.UsersMapper;
import com.myq.pojo.Users;
import com.myq.pojo.UsersExample;

import java.util.List;

public class userServiceimpl2 implements userService{
    private UsersMapper usersMapper;

    public UsersMapper getUsersMapper() {
        return usersMapper;
    }

    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public void addUser(Users users) {

    }

    @Override
    public List<Users> findUsersAll() {
        UsersExample usersExample = new UsersExample();
        return this.usersMapper.selectByExample(usersExample);
    }
}
