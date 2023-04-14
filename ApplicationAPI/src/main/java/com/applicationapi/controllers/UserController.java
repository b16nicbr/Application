package com.applicationapi.controllers;

import com.applicationapi.controllers.models.User;
import com.applicationapi.payload.response.JwtResponse;
import com.applicationservices.security.services.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/it-systems")
@Slf4j
public class UserController {

    @Autowired UserServiceImpl userService;


    @GetMapping("/management/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        com.applicationpersistence.entity.User user = userService.findById(id);

        if(user == null){
            log.warn("User :{} does not exist", user.getUsername());
            return ResponseEntity.notFound().build();
        }
        log.info("Found user :{}", user.getUsername());
        return ResponseEntity.ok(new User(user.getUser_id(), user.getUsername(), user.getPassword(), user.getAge(), user.getRole()));
    }

    @PostMapping("/management/create-user")
    public ResponseEntity<User> createUser(
            @RequestBody User userRequest){
        com.applicationpersistence.entity.User user = userService.insert(new com.applicationpersistence.entity.User(userRequest.id(),userRequest.name(), userRequest.password(), userRequest.age(), userRequest.role()));
        log.info("Created user: {}", user.getUsername());
        return ResponseEntity.ok(new User(user.getUser_id(), user.getUsername(), user.getPassword(), user.getAge(), user.getRole()));
    }
}
