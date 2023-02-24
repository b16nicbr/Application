package com.application.service;

import com.application.dao.UserDAO;
import org.springframework.stereotype.Service;


public class UserServiceImpl implements UserService{

    private UserDAO userService;

    public UserServiceImpl(UserDAO userService) {
        this.userService = userService;
    }

    @Override
    public void insert(UserDAO user) {
        userService.insert(user);
    }

    @Override
    public void update(UserDAO user) {
        userService.update(user);
    }

    @Override
    public void delete(UserDAO user) {
        userService.delete(user);
    }
}
