package com.applicationpersistence.entity;

import com.applicationpersistence.constants.RoleEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int role_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role;

    public Role(int role_id, RoleEnum role){
        this.role_id = role_id;
        this.role = role;
    }
    public Role(){}
}
