package com.applicationservices.security.services.impl;

import com.applicationpersistence.entity.Book;
import com.applicationpersistence.repositories.BookRepository;
import com.applicationservices.security.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findBookByName(String name) {
        return bookRepository.findBookByName(name);
    }

    @Override
    public List<Book> findBooksByAuthorName(String authorName) {
        return bookRepository.findBooksByAuthorName(authorName);
    }

    @Override
    public Book insert(Book newBook) {
        return bookRepository.save(newBook);
    }
}
