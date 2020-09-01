package com.lambdaschool.starthere.models;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @Column(unique = true,
            nullable = false)
    private String booktitle;
    private String ISBN;
    private  String user;
    private int copy;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",
               joinColumns = { @JoinColumn (name = "bookid") },
               inverseJoinColumns = { @JoinColumn (name = "authorid") })
    
    private Set<Author> authors;


    public Book()
    {
    }


    public Book(long bookid, String booktitle, String ISBN, String user, int copy, Set<Author> authors)
    {
        this.bookid = bookid;
        this.booktitle = booktitle;
        this.ISBN = ISBN;
        this.copy = copy;
        this.authors = authors;
        this.user = user;
    }

    public long getBookid()
    {
        return bookid;
    }

    public void setBookid(long bookid)
    {
        this.bookid = bookid;
    }

    public String getBooktitle()
    {
        return booktitle;
    }

    public void setBooktitle(String booktitle)
    {
        this.booktitle = booktitle;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }

    public int getCopy()
    {
        return copy;
    }

    public void setCopy(int copy)
    {
        this.copy = copy;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public Set<Author> getAuthors()
    {
        return authors;
    }

    public void setAuthors(Set<Author> authors)
    {
        this.authors = authors;
    }


}
