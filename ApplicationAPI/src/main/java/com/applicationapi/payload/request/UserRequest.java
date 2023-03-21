package com.applicationapi.payload.request;

public record UserRequest(int id, String name, String password, Integer age, String accesslevel) {
}
