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
    @Column(name = "author_name")
    @Size(min = 3, max = 50)
    String authorName;
    @Column(name = "price")
    double price;
    @Column(name = "note")
    @Size(max = 256)
    String note;

    public Book(String name, String authorName, double price, String note){
        this.name = name;
        this.authorName = authorName;
        this.price = price;
        this.note = note;
    }
}
