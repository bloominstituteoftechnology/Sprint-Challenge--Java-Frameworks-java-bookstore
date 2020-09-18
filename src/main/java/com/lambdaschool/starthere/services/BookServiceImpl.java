package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service (value = "bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository bookrepos;


    @Override
    public List<Book> findAll()
    {
        List<Book> list = new ArrayList<>();


        bookrepos.findAll().iterator().forEachRemaining(list::add);
        return list;

    }

    @Override
    public Book findBookById(long id)
    {
        return bookrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public List<Book> getBook(String title
    )
    {
        Book book = bookrepos.findByName(title);

        if (book == null)
        {
            throw new EntityNotFoundException("Book " + title + " not found!");
        }

        return (List<Book>) book;
    }

    @Override
    public void delete(long id)
    {

    }

    @Override
    public Book save(Book book)
    {
        return null;
    }
}
