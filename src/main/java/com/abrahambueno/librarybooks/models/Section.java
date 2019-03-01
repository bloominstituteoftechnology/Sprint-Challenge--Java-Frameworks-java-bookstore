package com.abrahambueno.librarybooks.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sectionid;

    private String name;

    @OneToMany(mappedBy = "sectionidtwo")
    @JsonIgnoreProperties("sectionidtwo")
    private Set<Book> books;

//    public Section() {@ManyToMany(cascade = CascadeType.ALL, mappedBy = "books")
//    @JsonIgnoreProperties("books")
//    private Set<>
//    }


    public Section() {
    }
}
