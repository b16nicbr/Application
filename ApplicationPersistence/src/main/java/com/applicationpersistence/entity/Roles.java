package com.applicationpersistence.entity;

import com.applicationpersistence.constants.RoleEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private RoleEnum name;

    public Roles(int id, RoleEnum name){
        this.id = id;
        this.name = name;
    }
    public Roles(){}
}
