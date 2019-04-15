package com.lambdaschool.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "sections")
public class Section {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "section_id")
  private long id;

  private String name;

  @OneToMany(mappedBy = "section", fetch = FetchType.EAGER)
  @JsonIgnoreProperties("section")
  private Set<Book> books;

  public Section() {}
}
