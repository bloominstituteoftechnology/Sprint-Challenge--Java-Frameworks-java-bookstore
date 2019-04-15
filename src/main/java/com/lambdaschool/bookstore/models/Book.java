package com.lambdaschool.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "book_id")
  private long id;

  private String title;

  private String isbn;

  private int copy;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "section_id")
  @JsonIgnoreProperties("books")
  private Section section;

  @ManyToMany(
    cascade = CascadeType.ALL,
    mappedBy = "books",
    fetch = FetchType.EAGER
  )
  private Set<Author> authors;

  public Book() {}
}
