package com.bookwarm.library.persistence.repositories;

import com.bookwarm.library.persistence.model.Cycle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CycleRepository extends CrudRepository<Cycle, Long> {
    List<Cycle> findByName(String name);
}
