package com.abrahambueno.librarybooks.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookid;

    private String booktitle;
    private String isbn;
    private int copy;

    // foreign key sectionid
    @ManyToOne
    @JoinColumn(name = "sectionid")
    @JsonIgnoreProperties("sections")
    private Section sectionidtwo;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "books")
    @JsonIgnoreProperties("books")
    private Set<Author> authors;

}
