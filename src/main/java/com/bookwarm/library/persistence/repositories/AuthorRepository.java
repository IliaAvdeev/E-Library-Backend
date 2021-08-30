package com.bookwarm.library.persistence.repositories;

import com.bookwarm.library.persistence.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findByName(String name);
}
