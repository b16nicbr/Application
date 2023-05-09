package com.applicationpersistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @NotBlank
    private String password;
    @Column(name = "age")
    private Integer age;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Roles> roles = new HashSet<>();

    public User(){}

    public User(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
