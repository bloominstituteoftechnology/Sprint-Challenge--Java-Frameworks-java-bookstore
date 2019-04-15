package com.lambdaschool.bookstore.services.implementations;

import com.lambdaschool.bookstore.models.User;
import com.lambdaschool.bookstore.repositories.UserRepository;
import com.lambdaschool.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
  @Autowired
  private UserRepository userRepository;

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("Invalid username or password.");
    }
    return new org.springframework.security.core.userdetails.User(
      user.getUsername(), user.getPassword(), user.getAuthority()
    );
  }

  public List<User> findAll() {
    List<User> users = new ArrayList<>();
    userRepository.findAll().iterator().forEachRemaining(users::add);
    return users;
  }

  @Override
  public void delete(long id) {
    userRepository.deleteById(id);
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }
}
