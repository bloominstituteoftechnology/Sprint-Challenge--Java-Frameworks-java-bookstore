package com.lambdaschool.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
@JsonIgnoreProperties(value = "hasvalueforcopy")
public class Book
        extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    private String title;
    private String isbn;
    @Transient
    public boolean hasvalueforcopy = false;
    private int copy;

    @ManyToOne
    @JoinColumn(name = "sectionid")
    @JsonIgnoreProperties("books")
    private Section section;

    @OneToMany(mappedBy = "book",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties("book")
    private Set<Wrote> wrotes = new HashSet<>();

    public Book()
    {
    }

    public Book(String title,
                String isbn,
                int copy,
                Section section)
    {
        this.title = title;
        this.isbn = isbn;
        this.copy = copy;
        this.section = section;
    }

    public long getBookid()
    {
        return bookid;
    }

    public void setBookid(long bookid)
    {
        this.bookid = bookid;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public int getCopy()
    {
        return copy;
    }

    public void setCopy(int copy)
    {
        hasvalueforcopy = true;
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

    public Set<Wrote> getWrotes()
    {
        return wrotes;
    }

    public void setWrotes(Set<Wrote> wrotes)
    {
        this.wrotes = wrotes;
    }

    @Override
    public String toString()
    {
        return "Book{" +
            "bookid=" + bookid +
            ", title='" + title + '\'' +
            ", isbn='" + isbn + '\'' +
            ", hasvalueforcopy=" + hasvalueforcopy +
            ", copy=" + copy +
            ", section=" + section +
            ", wrotes=" + wrotes +
            '}';
    }
}
