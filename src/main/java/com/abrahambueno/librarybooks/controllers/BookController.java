package com.abrahambueno.librarybooks.controllers;

import com.abrahambueno.librarybooks.models.Book;
import com.abrahambueno.librarybooks.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    @Autowired
    private BookRepository bookrepos;

    @GetMapping("/books")
    public List<Book> getAllBookDetailInformation() {
        var foundBooks = bookrepos.findAll();
        if (foundBooks != null) {
            return foundBooks;
        } else {
            return null;
        }
    }

}
