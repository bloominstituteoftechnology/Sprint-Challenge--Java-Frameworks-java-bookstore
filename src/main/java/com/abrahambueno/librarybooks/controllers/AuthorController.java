package com.abrahambueno.librarybooks.controllers;

import com.abrahambueno.librarybooks.models.Author;
import com.abrahambueno.librarybooks.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {
    @Autowired
    private AuthorRepository authorrepos;

    @GetMapping("/authors")
    public List<Author> getAllBookDetailInformation() {
        var foundBooks = authorrepos.findAll();
        if (foundBooks != null) {
            return foundBooks;
        } else {
            return null;
        }
    }
}
