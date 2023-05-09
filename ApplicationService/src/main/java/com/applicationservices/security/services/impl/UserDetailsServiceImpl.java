package com.applicationservices.security.services.impl;

import com.applicationpersistence.entity.User;
import com.applicationpersistence.repositories.UserRepository;
import com.applicationservices.security.services.UserDetailsPrincipal;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDetailsPrincipalImpl userDetails;
    @Override
    @Transactional
    public UserDetailsPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }
        System.out.println("IM IN HERE");
        return UserDetailsPrincipalImpl.build(user);
    }
}
