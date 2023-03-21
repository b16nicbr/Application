package com.applicationpersistence.entity;

import com.applicationpersistence.constants.RoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    @Column(name = "name")
    private String username;

    @Column(name = "password")
    @NotBlank
    private String password;
    @Column(name = "age")
    private Integer age;
    @Column(name = "role")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> role = new HashSet<>();

    public User(int user_id, String username, String password, Integer age, Set<Role> role) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.role = role;
    }

    public User(){}
}
