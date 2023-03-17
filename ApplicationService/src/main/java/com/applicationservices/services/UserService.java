package com.applicationservices.services;

import com.applicationpersistence.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    User insert(User user);

    User update(User user, int ID);

    void delete(User user);

    User findById(int ID);
}
