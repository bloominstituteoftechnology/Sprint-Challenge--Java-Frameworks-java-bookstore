package com.abrahambueno.librarybooks.controllers;

import com.abrahambueno.librarybooks.models.Book;
import com.abrahambueno.librarybooks.repositories.AuthorRepository;
import com.abrahambueno.librarybooks.repositories.BookRepository;
import com.abrahambueno.librarybooks.repositories.SectionRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@Api(value = "Library Application", description = "The classic Library Application in CRUD")
@RequestMapping(value = "/data/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {
    @Autowired
    private AuthorRepository authorrepos;
    @Autowired
    private  BookRepository bookrepos;
    @Autowired
    private SectionRepository sectionrepos;

    @ApiOperation(value = "Update Book based off book id", response = Book.class)
    @PutMapping("/books/{id}")
    public Book changeBook(@ApiParam(value = "This is the Book you want to update", required = true) @RequestBody Book book,
                           @ApiParam(value = "This is the book id you want to update", required = true) @PathVariable long id) throws URISyntaxException {
        Optional<Book> updateBook = bookrepos.findById(id);
        if (updateBook.isPresent()) {
            if (book.getAuthors() == null) {
                book.setAuthors(updateBook.get().getAuthors());
            }

            if (book.getBooktitle() == null) {
                book.setBooktitle(updateBook.get().getBooktitle());
            }
//            if (book.getCopy() == null) {
//                book.setCopy(updateBook.get().getCopy());
//            }
            if (book.getIsbn() == null) {
                book.setIsbn(updateBook.get().getIsbn());
            }
            if (book.getSectionidtwo() == null) {
                book.setSectionidtwo(updateBook.get().getSectionidtwo());
            }
            book.setBookid(id);
            bookrepos.save(book);
            return book;
        } else {
            return null;
        }

    }

    @ApiOperation(value = "Create bookid and authorid relation with book id and author id", response = String.class)
    @PostMapping("/books/{bookid}/authors/{id}")
    public String assignAuthorToBook(@ApiParam(value = "This is the book you want to create a relation to the author", required = true) @PathVariable long bookid,
                                     @ApiParam(value = "This is the author id you want to create a relation to the book", required = true) @PathVariable long id) throws URISyntaxException {
        bookrepos.setBookAuthors(bookid, id);
        return "{" + "\"bookid\":" + bookid +
                ",\"authorid\":" + id + "}";
//        return "Temp";
    }
//
    @ApiOperation(value = "Delete book based off of book id", response = Book.class)
    @DeleteMapping("/books/{id}")
    public Book deleteBook(@ApiParam(value = "This is the book id you want to deleteW", required = true) @PathVariable long id) throws URISyntaxException {
        var deleteBook = bookrepos.findById(id);
        if (deleteBook.isPresent()) {
            bookrepos.deleteById(id);
            return deleteBook.get();
        } else {
            return null;
        }
    }
}
