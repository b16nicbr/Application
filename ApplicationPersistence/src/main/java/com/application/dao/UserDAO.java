package com.application.dao;

import org.springframework.stereotype.Service;


public interface UserDAO {

    void insert(UserDAO user);

    void update(UserDAO user);

    void delete(UserDAO user);
}
