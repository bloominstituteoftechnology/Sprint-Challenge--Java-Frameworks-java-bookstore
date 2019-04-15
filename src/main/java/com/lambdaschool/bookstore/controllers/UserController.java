package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.models.User;
import com.lambdaschool.bookstore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
  @Autowired
  UserRepository userRepository;

  @GetMapping
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @DeleteMapping(value = "{id}")
  public User deleteById(@PathVariable("id") long id) {
    var foundUser = userRepository.findById(id);

    if (foundUser.isPresent()) {
      User user = foundUser.get();

      userRepository.deleteById(id);

      return user;
    }

    return null;
  }

  @PostMapping
  public User addUser(@RequestBody User newUser) {
    return userRepository.save(newUser);
  }
}
