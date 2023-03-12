package com.application.services;

import com.application.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    User insert(User user);

    User update(User user, int ID);

    void delete(User user);

    User findById(int ID);
}
