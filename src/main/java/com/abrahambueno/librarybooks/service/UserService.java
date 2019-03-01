package com.abrahambueno.librarybooks.service;

import com.abrahambueno.librarybooks.models.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    void delete(long id);
}
