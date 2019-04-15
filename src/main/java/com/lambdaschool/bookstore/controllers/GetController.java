package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.models.Author;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.models.Section;
import com.lambdaschool.bookstore.repositories.AuthorRepository;
import com.lambdaschool.bookstore.repositories.BookRepository;
import com.lambdaschool.bookstore.repositories.SectionRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(
  description = "Contains GET endpoints for authors, books, and sections"
)
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class GetController {
  @Autowired
  BookRepository bookRepository;

  @ApiOperation(value = "Lists all books or an empty list")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Successfully retrieved books")
  })
  @GetMapping(value = "books")
  List<Book> findAllBooks() {
    return bookRepository.findAll();
  }

  @Autowired
  AuthorRepository authorRepository;

  @ApiOperation(value = "Lists all authors or an empty list")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Successfully retrieved authors")
  })
  @GetMapping(value = "authors")
  List<Author> findAllAuthors() {
    return authorRepository.findAll();
  }

  @Autowired
  SectionRepository sectionRepository;

  @ApiOperation(value = "Lists all sections or an empty list", response = List.class)
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Successfully retrieved sections")
  })
  @GetMapping(value = "sections")
  List<Section> findAllSections() {
    return sectionRepository.findAll();
  }
}
