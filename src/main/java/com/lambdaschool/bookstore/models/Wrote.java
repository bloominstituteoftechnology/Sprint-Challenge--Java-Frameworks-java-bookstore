package com.lambdaschool.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "wrote")
@IdClass(WroteId.class)
public class Wrote
        extends Auditable
        implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "authorid")
    @JsonIgnoreProperties("wrotes")
    private Author author;

    @Id
    @ManyToOne
    @JoinColumn(name = "bookid")
    @JsonIgnoreProperties("wrotes")
    private Book book;

    public Wrote()
    {
    }

    public Wrote(Author author,
                 Book book)
    {
        this.author = author;
        this.book = book;
    }

    public Author getAuthor()
    {
        return author;
    }

    public void setAuthor(Author author)
    {
        this.author = author;
    }

    public Book getBook()
    {
        return book;
    }

    public void setBook(Book book)
    {
        this.book = book;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Wrote))
        {
            return false;
        }
        Wrote that = (Wrote) o;
        return ((author == null) ? 0 : author.getAuthorid()) == ((that.author == null) ? 0 : that.author.getAuthorid()) &&
                ((book == null) ? 0 : book.getBookid()) == ((that.book == null) ? 0 : that.book.getBookid());
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}

