package com.applicationpersistence.repositories;

import com.applicationpersistence.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findBookByName(String name);

    List<Book> findBooksByAuthorName(String authorName);
}
