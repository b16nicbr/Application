package com.applicationservices.security.services;

import com.applicationpersistence.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookService {

    Book findBookByName(String name);

    List<Book> findBooksByAuthor(String authorName);

    Book insert(Book newBook);
}
