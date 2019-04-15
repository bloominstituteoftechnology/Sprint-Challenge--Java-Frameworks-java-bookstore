package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.models.Author;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.models.Section;
import com.lambdaschool.bookstore.repositories.AuthorRepository;
import com.lambdaschool.bookstore.repositories.BookRepository;
import com.lambdaschool.bookstore.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class GetController {
  @Autowired
  BookRepository bookRepository;

  @RequestMapping(value = "books")
  List<Book> findAllBooks() {
    return bookRepository.findAll();
  }

  @Autowired
  AuthorRepository authorRepository;

  @RequestMapping(value = "authors")
  List<Author> findAllAuthors() {
    return authorRepository.findAll();
  }

  @Autowired
  SectionRepository sectionRepository;

  @RequestMapping(value = "sections")
  List<Section> findAllSections() {
    return sectionRepository.findAll();
  }
}
