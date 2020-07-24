package com.lambdaschool.bookstore.models;

import java.io.Serializable;
import java.util.Objects;

public class WroteId
        implements Serializable
{
    private long author;
    private long book;

    public WroteId()
    {
    }

    public long getAuthor()
    {
        return author;
    }

    public void setAuthor(long author)
    {
        this.author = author;
    }

    public long getBook()
    {
        return book;
    }

    public void setBook(long book)
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
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        WroteId wroteId = (WroteId) o;
        return author == wroteId.author &&
                book == wroteId.book;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(author, book);
    }
}
