package com.lambdaschool.foundation.controllers;


import com.lambdaschool.foundation.models.Book;
import com.lambdaschool.foundation.models.ErrorDetail;
import com.lambdaschool.foundation.services.BookService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController
{
  @Autowired
  private BookService bookService;

  @ApiOperation(value = "list all books",
                response = Book.class,
                responseContainer = "List")
  @ApiImplicitParams({
                         @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                                           value = "Results page you want to retrieve (1..N)"),
                         @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                                           value = "Number of records per page."),
                         @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                                           value = "Sorting criteria in the format: property(,asc|desc). " +
                                               "Default sort order is ascending. " +
                                               "Multiple sort criteria are supported.")})
  // GET /books/books - returns a JSON object list of all the books, their sections, and their authors.
  @PreAuthorize("hasAnyRole('ADMIN')")
  @GetMapping(value = "/books", produces = {"application/json"})
  public ResponseEntity<?> listAllBooks()
  {
    List<Book> myBooks = bookService.findAll();
    return new ResponseEntity<>(myBooks, HttpStatus.OK);
  }




  @ApiOperation(value = "delete a book using book id")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Book Deleted"), @ApiResponse(code = 404, message = "Book Not Found",
          response = ErrorDetail.class)})
  // DELETE /data/books/{id} - deletes a book and the book author combinations - but does not delete the author records.
  @DeleteMapping(value = "/data/books/{id}")
  public ResponseEntity<?> deleteBook(@PathVariable long id)
  {
    bookService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
