package com.bookwarm.library.persistence.repositories;

import com.bookwarm.library.persistence.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long>, PagingAndSortingRepository<Author, Long> {
    List<Author> findByName(String name);
}
