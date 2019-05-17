package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
