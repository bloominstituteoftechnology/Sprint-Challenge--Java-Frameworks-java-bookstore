package com.lambdaschool.bookstore.repositories;

import com.lambdaschool.bookstore.models.User;

public interface UserRepository extends BaseJpaRepository<User> {
  User findByUsername(String username);
}
