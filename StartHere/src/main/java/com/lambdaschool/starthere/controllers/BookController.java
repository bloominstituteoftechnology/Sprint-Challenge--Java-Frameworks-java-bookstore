package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public ResponseEntity<?> findAllBooks(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/data/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable long id, @RequestBody Book book){
        bookService.updateBook(book, id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping(value = "/data/books/{id}")
    public ResponseEntity<?> matchBookWithAuthor(@PathVariable long id, @RequestBody Author author){
        bookService.assignAuthor(id, author.getAuthorid());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/data/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id){
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
