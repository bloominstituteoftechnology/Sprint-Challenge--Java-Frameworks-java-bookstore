package com.lambdaschool.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private long id;

  private String username;

  @JsonIgnore
  private String password;

  private String role;

  public User() {}

  public List<SimpleGrantedAuthority> getAuthority() {
    String authority = "ROLE_" + role.toUpperCase();
    return Arrays.asList(new SimpleGrantedAuthority(authority));
  }
}
