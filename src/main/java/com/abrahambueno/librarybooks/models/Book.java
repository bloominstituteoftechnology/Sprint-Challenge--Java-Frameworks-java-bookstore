package com.abrahambueno.librarybooks.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
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
    @JsonIgnoreProperties("books")
    private Section sectionidtwo;

    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties("books")
    private Set<Author> authors = new HashSet<>();


    public Book() {
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public Section getSectionidtwo() {
        return sectionidtwo;
    }

    public void setSectionidtwo(Section sectionidtwo) {
        this.sectionidtwo = sectionidtwo;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
