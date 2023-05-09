package com.applicationapi.controllers.models;

import com.applicationpersistence.entity.Roles;

import java.util.Set;

public record User(int id, String name, String password, Integer age, Set<Roles> role) {
}
