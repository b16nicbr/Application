package com.applicationservices.security.services.impl;

import com.applicationpersistence.entity.User;
import com.applicationpersistence.repositories.UserRepository;
import com.applicationservices.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user, int ID) {
        User userdb = userRepository.findById(ID).get();

        userdb.setUsername(user.getUsername());
        userdb.setAge(user.getAge());
        userdb.setAccesslevel(user.getAccesslevel());


        return userRepository.save(userdb);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User findById(int ID) {
        User one = userRepository.findById(ID).get();
        return one;
    }
}
