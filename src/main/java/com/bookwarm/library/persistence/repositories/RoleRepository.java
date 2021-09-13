package com.bookwarm.library.persistence.repositories;

import com.bookwarm.library.persistence.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
