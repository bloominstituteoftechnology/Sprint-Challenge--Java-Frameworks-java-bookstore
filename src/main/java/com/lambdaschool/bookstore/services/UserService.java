package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.models.User;

import java.util.List;

public interface UserService {
  User save(User user);

  List<User> findAll();

  void delete(long id);
}
