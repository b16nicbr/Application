package com.applicationapi.controllers;

import com.applicationapi.controllers.models.UserRequest;
import com.applicationapi.controllers.models.UserResponse;
import com.applicationpersistence.entity.User;
import com.applicationservices.services.impl.UserServiceImpl;
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
    public ResponseEntity<UserResponse> getUser(@PathVariable int id){
        User user = userService.findById(id);

        if(user == null){
            log.warn("User :{} does not exist", user.getName());
            return ResponseEntity.notFound().build();
        }
        log.info("Found user :{}", user.getName());
        return ResponseEntity.ok(new UserResponse(user.getId(), user.getName(), user.getAge(), user.getAccesslevel()));
    }

    @PostMapping("/management/create-user")
    public ResponseEntity<UserResponse> createUser(
            @RequestBody UserRequest userRequest){
        User user = userService.insert(new User(userRequest.id(),userRequest.name(), userRequest.age(), userRequest.accesslevel()));

        return ResponseEntity.ok(new UserResponse(user.getId(), user.getName(), user.getAge(), user.getAccesslevel()));
    }
}
