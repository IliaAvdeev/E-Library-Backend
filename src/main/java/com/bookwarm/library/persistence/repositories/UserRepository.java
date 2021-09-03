package com.bookwarm.library.persistence.repositories;

import com.bookwarm.library.persistence.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);
}
