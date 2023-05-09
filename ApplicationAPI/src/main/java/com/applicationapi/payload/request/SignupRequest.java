package com.applicationapi.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@ToString
@AllArgsConstructor
public class SignupRequest {

    String username;
    String password;

    Integer age;
    Set<String> roles;



}
