package com.applicationapi.payload.response;

import com.applicationpersistence.constants.RoleEnum;
import com.applicationpersistence.entity.Role;

import java.util.Set;

public record UserResponse(int id, String name, String password, Integer age, Set<Role> role) {
}
