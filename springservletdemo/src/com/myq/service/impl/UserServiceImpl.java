package com.myq.service.impl;

import com.myq.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(String username) {
        System.out.println("AddUser...."+username);
    }
}
