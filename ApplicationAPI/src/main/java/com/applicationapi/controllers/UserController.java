package com.applicationapi.controllers;

import com.applicationapi.controllers.models.User;
import com.applicationservices.security.services.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/it-systems")
@Slf4j
@Tag(name = "User", description = "User APIs for adding and retrieving users in bookstore")
public class UserController {

    @Autowired UserServiceImpl userService;


    @GetMapping("/management/{username}")
    @PreAuthorize("hasRole('moderator') or hasRole('user') or hasRole('admin')")
    public ResponseEntity<User> getUser(@PathVariable String username){
        com.applicationpersistence.entity.User user = userService.findByUsername(username);

        if(user == null){
            log.warn("User :{} does not exist", username);
            return ResponseEntity.notFound().build();
        }
        log.info("Found user :{}", user.getUsername());
        return ResponseEntity.ok(new User(user.getId(), user.getUsername(), user.getPassword(), user.getAge(), user.getRoles()));
    }

    @PostMapping("/management/create-user") @PreAuthorize("hasRole('moderator') or hasRole('admin')")
    public ResponseEntity<User> createUser(
            @RequestBody User userRequest){
        com.applicationpersistence.entity.User user = userService.insert(new com.applicationpersistence.entity.User(userRequest.id(),userRequest.name(), userRequest.password(), userRequest.age(), userRequest.role()));
        log.info("Created user: {}", user.getUsername());
        return ResponseEntity.ok(new User(user.getId(), user.getUsername(), user.getPassword(), user.getAge(), user.getRoles()));
    }
}
