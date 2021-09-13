package com.bookwarm.library.persistence.repositories;

import com.bookwarm.library.persistence.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long>, PagingAndSortingRepository<Book, Long> {
    List<Book> findByAuthorId(long authorId);

    List<Book> findByGenreId(long genreId);

    List<Book> findByCycleId(long cycleId);
}
