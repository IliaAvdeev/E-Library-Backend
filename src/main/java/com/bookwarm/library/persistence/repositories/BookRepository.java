package com.bookwarm.library.persistence.repositories;

import com.bookwarm.library.persistence.model.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByAuthorId(long authorId);
    List<Book> findByGenreId(long genreId);
    List<Book> findByCycleId(long cycleId);
}
