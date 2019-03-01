package com.abrahambueno.librarybooks.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long section;

    private String name;

    @OneToMany(mappedBy = "sectionidtwo")
    @JsonIgnoreProperties("sectionidtwo")
    private Set<Book> books;
}
