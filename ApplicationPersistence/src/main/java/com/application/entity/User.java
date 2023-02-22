package com.application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity()
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int ID;

    String name;

    Integer age;

    String accesslevel;

    public User(int ID, String name, Integer age, String accesslevel){
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.accesslevel = accesslevel;
    }
    public User(){}

}
