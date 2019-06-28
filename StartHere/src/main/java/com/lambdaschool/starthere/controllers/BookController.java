package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.models.ErrorDetail;
import com.lambdaschool.starthere.services.BookService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
public class BookController
{
    @Autowired
    private BookService bookService;

    @ApiOperation(value = "Return all Books", response = Book.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integr", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})

    @GetMapping(value = "/books")
    public ResponseEntity<?> findAllBooks(Pageable pageable){
        return new ResponseEntity<>(bookService.findAll(pageable), HttpStatus.OK);
    }
    @ApiOperation(value = "Update a current Book", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully updated book", response = void.class),
            @ApiResponse(code = 500, message = "Failed to update book", response = ErrorDetail.class)
    })

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

    @ApiOperation(value = "Delete a current book", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Succesfully deleted book", response = void.class),
            @ApiResponse(code = 500, message = "Failed to delete book", response = ErrorDetail.class)
    })

    @DeleteMapping(value = "/data/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id){
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
