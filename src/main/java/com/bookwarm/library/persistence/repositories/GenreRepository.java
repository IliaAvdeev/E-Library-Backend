package com.bookwarm.library.persistence.repositories;

import com.bookwarm.library.persistence.model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GenreRepository extends CrudRepository<Genre, Long>, PagingAndSortingRepository<Genre, Long> {
}
