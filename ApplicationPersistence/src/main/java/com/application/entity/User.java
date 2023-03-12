package com.application.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.relational.core.sql.In;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int ID;
    @Column(name = "name")
    String name;
    @Column(name = "age")
    Integer age;
    @Column(name = "accesslevel")
    String accesslevel;


}
