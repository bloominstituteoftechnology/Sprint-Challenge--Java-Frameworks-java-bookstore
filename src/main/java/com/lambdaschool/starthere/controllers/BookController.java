package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class BookController
{

    @Autowired
    private BookRepository bookrepos;

    @GetMapping(value = "/Books")
    public List<Book> getAllBooks()
    {
        return (List<Book>) bookrepos.findAll();
    }

    @PostMapping(value = "/Book")
    public Book newBook(
            @RequestBody
                    Book newBook)
    {
        return bookrepos.save(newBook);
    }

    @GetMapping(value = "/Book")
    public Book getBook(
            @RequestParam
                    Long bookId)
    {
        Optional<Book> book = bookrepos.findById(bookId);
        if (book.isPresent())
        {
            return book.get();
        }
        return null;
    }
}

