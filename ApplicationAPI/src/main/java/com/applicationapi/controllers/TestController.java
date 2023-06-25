package com.applicationapi.controllers;

import com.applicationapi.payload.response.JwtResponse;
import com.applicationpersistence.repositories.RoleRepository;
import com.applicationpersistence.repositories.UserRepository;
import com.applicationservices.security.jwt.JwtUtils;
import com.applicationservices.security.services.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/test")
public class TestController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping(path = "/refresh-token")
    public ResponseEntity<JwtResponse> refreshToken(HttpServletRequest httpServletRequest,
                                                    @RequestBody String token){

        String refreshedToken = jwtUtils.refreshJwtToken(httpServletRequest, token);
        return ResponseEntity.ok(new JwtResponse(refreshedToken));
    }

}
