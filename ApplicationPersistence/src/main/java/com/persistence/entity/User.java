package com.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int ID;

    private String name;

    private Integer age;

    private String accesslevel;

    public User(int ID, String name, Integer age, String accesslevel){
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.accesslevel = accesslevel;
    }
    public User(){}

}
