package com.bookwarm.library.persistence.repositories;

import com.bookwarm.library.persistence.model.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(Author author);
    List<Book> findByGenre(Genre genre);
    List<Book> findByCycle(Cycle cycle);
}
