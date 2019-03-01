package com.abrahambueno.librarybooks.repositories;

import com.abrahambueno.librarybooks.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
