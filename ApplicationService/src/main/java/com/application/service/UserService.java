package com.application.service;

import com.application.dao.UserDAO;
import org.springframework.stereotype.Service;


public interface UserService {

    void insert(UserDAO user);
    void update(UserDAO user);

    void delete(UserDAO user);

}
