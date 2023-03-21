package com.applicationapi.controllers.models;

import com.applicationpersistence.constants.RoleEnum;
import com.applicationpersistence.entity.Role;

import java.util.Set;

public record User(int id, String name, String password, Integer age, Set<Role> role) {
}
