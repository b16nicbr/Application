package com.applicationpersistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "name")
    @Size(max = 50)
    String name;
    @Column(name = "author")
    @Size(min = 3, max = 50)
    String author;
    @Column(name = "price")
    double price;
    @Column(name = "note")
    @Size(max = 256)
    String note;

    public Book(String name, String author, double price, String note){
        this.name = name;
        this.author = author;
        this.price = price;
        this.note = note;
    }
}
