package com.lambdaschool.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "sections")
public class Section {
  @Id
  @GeneratedValue
  @Column(name = "section_id")
  private long id;

  private String name;

  @OneToMany(mappedBy = "section", fetch = FetchType.EAGER)
  @JsonIgnoreProperties("section")
  private Set<Book> books;
}
