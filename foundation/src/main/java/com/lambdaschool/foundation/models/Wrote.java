package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "wrote",
       uniqueConstraints = {@UniqueConstraint(columnNames = {"bookid", "authorid"})})
public class Wrote extends Auditable implements Serializable
{

  @Id
  @ManyToOne
  @JoinColumn(name = "bookid")
  @JsonIgnoreProperties(value = "author",allowSetters = true)
  private Book book;

  @Id
  @ManyToOne
  @JoinColumn(name = "authorid")
  @JsonIgnoreProperties(value = "book", allowSetters = true)
  private Author author;

  public Wrote()
  {
  }

  public Wrote(Author author, Book book)
  {
    this.book = book;
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

  public Author getAuthor()
  {
    return author;
  }

  public void setAuthor(Author author)
  {
    this.author = author;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
    {
      return true;
    }
    if (o == null || getClass() != o.getClass())
    {
      return false;
    }
    Wrote wrote = (Wrote) o;
    return Objects.equals(book, wrote.book) && Objects.equals(author, wrote.author);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(book, author);
  }
}
