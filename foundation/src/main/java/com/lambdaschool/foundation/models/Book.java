package com.lambdaschool.foundation.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book extends Auditable
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long bookid;

  @Column(nullable = false)
  private String booktitle;

  @Column(nullable = false,
          unique = true)
  private String ISBN;

  private Integer copy;

  @ManyToOne
  @JoinColumn(name = "sectionid")
  @JsonIgnoreProperties(value = "books", allowSetters = true)
  private Section section;

  @OneToMany(mappedBy = "book",
             cascade = CascadeType.ALL)
  @JsonIgnoreProperties(value = "book", allowSetters = true)
  private List<Wrote> author = new ArrayList<>();

  public Book()
  {
  }

  public Book(String booktitle, String ISBN, Integer copy, Section section)
  {
    this.booktitle = booktitle;
    this.ISBN = ISBN;
    this.copy = copy;
    this. section = section;
  }


  public void setAuthor(List<Wrote> author) {
    this.author = author;
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

  public Integer getCopy()
  {
    return copy;
  }

  public void setCopy(Integer copy)
  {
    this.copy = copy;
  }

  public Section getSection()
  {
    return section;
  }

  public void setSection(Section section)
  {
    this.section = section;
  }

  public List<Wrote> getAuthor()
  {
    return author;
  }

  public void setWrotes(List<Wrote> wrote)
  {
    this.author = wrote;
  }



  @Override
  public String toString()
  {
    return "Book{" + "bookid=" + bookid + ", booktitle='" + booktitle + '\'' + ", ISBN='" + ISBN + '\'' + ", copy=" + copy + ", section=" + section + ", wrote=" + author + '}';
  }
}
