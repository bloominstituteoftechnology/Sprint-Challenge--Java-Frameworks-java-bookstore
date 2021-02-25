package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @Column(nullable = false)
    private String booktitle;

    private String isbn;

    private String copy;

    @ManyToMany
    @JsonIgnoreProperties(value = "bookList")
    @JoinTable(name = "wrote", joinColumns = {@JoinColumn(name = "bookid")}, inverseJoinColumns = {@JoinColumn(name = "authorid")})
    List<Author> authorList = new ArrayList<>();

    public Book() {
    }

    public Book(String booktitle, String isbn, String copy) {
        this.booktitle = booktitle;
        this.isbn = isbn;
        this.copy = copy;
    }

    public Book(String booktitle, String isbn, String copy, List<Author> authorList) {
        this.booktitle = booktitle;
        this.isbn = isbn;
        this.copy = copy;
        this.authorList = authorList;
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

    public String getCopy() {
        return copy;
    }

    public void setCopy(String copy) {
        this.copy = copy;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }
}
