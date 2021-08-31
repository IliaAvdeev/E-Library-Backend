package com.bookwarm.library.persistence.repositories;

import com.bookwarm.library.persistence.model.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    List<Genre> findByName(String name);
}
