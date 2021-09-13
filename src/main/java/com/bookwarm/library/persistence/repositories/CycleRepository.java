package com.bookwarm.library.persistence.repositories;

import com.bookwarm.library.persistence.model.Cycle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CycleRepository extends CrudRepository<Cycle, Long>, PagingAndSortingRepository<Cycle, Long> {
}
