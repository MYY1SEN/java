package com.MYQ.dao;

import com.MYQ.pojo.users;

public interface UserLoginDao {
    public users selectUsersByUsernameandUserpwd(String username,String userpwd);
}
