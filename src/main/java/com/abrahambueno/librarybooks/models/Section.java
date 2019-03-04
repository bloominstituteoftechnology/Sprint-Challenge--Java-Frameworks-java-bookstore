package com.abrahambueno.librarybooks.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "section")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sectionid;

    private String name;

    @OneToMany(mappedBy = "sectionidtwo")
    @JsonIgnoreProperties("sections")
    private Set<Book> books = new HashSet<>();

//    public Section() {@ManyToMany(cascade = CascadeType.ALL, mappedBy = "books")
//    @JsonIgnoreProperties("books")
//    private Set<>
//    }


    public Section() {
    }

    public long getSectionid() {
        return sectionid;
    }

    public void setSectionid(long sectionid) {
        this.sectionid = sectionid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
