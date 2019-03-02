package com.abrahambueno.librarybooks.controllers;

import com.abrahambueno.librarybooks.models.Book;
import com.abrahambueno.librarybooks.repositories.AuthorRepository;
import com.abrahambueno.librarybooks.repositories.BookRepository;
import com.abrahambueno.librarybooks.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/data/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {
    @Autowired
    private AuthorRepository authorrepos;
    @Autowired
    private  BookRepository bookrepos;
    @Autowired
    private SectionRepository sectionrepos;
    @PutMapping("/books/{id}")
    public Book changeBook(@RequestBody Book book, @PathVariable long id) throws URISyntaxException {
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

    @PostMapping("/books/{bookid}/authors/{id}")
    public String assignAuthorToBook(@PathVariable long bookid, @PathVariable long id) throws URISyntaxException {
//        bookrepos.setBookAuthors(bookid, id);
//        return "{" + "\"bookid\":" + bookid +
//                ",\"authorid\":" + authorid + "}";
        return "Temp";
    }
//
    @DeleteMapping("/books/{id}")
    public Book deleteBook(@PathVariable long id) throws URISyntaxException {
        var deleteBook = bookrepos.findById(id);
        if (deleteBook.isPresent()) {
            bookrepos.deleteById(id);
            return deleteBook.get();
        } else {
            return null;
        }
    }
}
