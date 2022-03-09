package com.myq.service;

import com.myq.mapper.UsersMapper;
import com.myq.pojo.Users;
import com.myq.pojo.UsersExample;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class userServiceimpl implements userService{
    private SqlSessionTemplate sqlSessionTemplate;

    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Users> findUsersAll() {
        UsersMapper mapper = this.sqlSessionTemplate.getMapper(UsersMapper.class);
        UsersExample usersExample = new UsersExample();
        return mapper.selectByExample(usersExample);
    }

    /**
     * 添加用户
     * @param users
     */
    @Override
    public void addUser(Users users) {
        UsersMapper mapper = this.sqlSessionTemplate.getMapper(UsersMapper.class);
        mapper.insertSelective(users);
    }
}
