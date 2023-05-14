package com.applicationapi.controllers;

import com.applicationapi.controllers.models.Book;
import com.applicationservices.security.services.impl.BookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/gunders")
@Slf4j
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @PostMapping(path = "/books/add-book")
    @PreAuthorize("hasRole('moderator') or hasRole('admin')")
    public ResponseEntity<Book> insertBooks(
            @RequestBody Book bookRequest){
        com.applicationpersistence.entity.Book insertBook = bookService.findBookByName(bookRequest.name());
        if(insertBook != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        log.info("added new book in table");
        bookService.insert(new com.applicationpersistence.entity.Book(bookRequest.name(), bookRequest.authorName(), bookRequest.price(), bookRequest.note()));
        return ResponseEntity.ok(bookRequest);

    }
    @GetMapping(path = "/books/book/{name}")
    @PreAuthorize("hasRole('moderator') or hasRole('admin') or hasRole('user')")
    public ResponseEntity<Book> getBook(
            @PathVariable(value = "name") String name){
        com.applicationpersistence.entity.Book book = bookService.findBookByName(name);
        if(book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        log.info("found book");
        return ResponseEntity.ok(new Book(book.getName(), book.getAuthorName(), book.getPrice(), book.getNote()));

    }

    @GetMapping(path = "/books/by-author/{name}")
    @PreAuthorize("hasRole('moderator') or hasRole('admin') or hasRole('user')")
    public ResponseEntity<List<com.applicationpersistence.entity.Book>> getBooksByAuthor(
            @PathVariable(value = "name") String author_name){
        List<com.applicationpersistence.entity.Book> book = bookService.findBooksByAuthorName(author_name);
        if(book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        log.info("found books by author");
        return ResponseEntity.ok(book);

    }
}
