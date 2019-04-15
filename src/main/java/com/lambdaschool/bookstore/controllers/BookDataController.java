package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.models.transactional.AuthorJoinBook;
import com.lambdaschool.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "data/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookDataController {
  @Autowired
  BookRepository bookRepository;

  @PutMapping(value = "{id}")
  public Book updateBook(@RequestBody Book newBook, @PathVariable("id") long id) {
    var foundBook = bookRepository.findById(id);

    if (foundBook.isPresent()) {
      Book oldBook = foundBook.get();

      if (newBook.getTitle() == null) {
        newBook.setTitle(oldBook.getTitle());
      }
      if (newBook.getIsbn() == null) {
        newBook.setIsbn(oldBook.getIsbn());
      }
      if (newBook.getCopy() == 0) {
        newBook.setCopy(oldBook.getCopy());
      }

      newBook.setId(id);

      return bookRepository.save(newBook);
    }

    return null;
  }

  @PostMapping(value = "{bookId}/authors/{authorId}")
  public AuthorJoinBook addAuthorJoinBook(
    @PathVariable("bookId") long bookId, @PathVariable("authorId") long authorId
  ) {
    AuthorJoinBook authorJoinBook = new AuthorJoinBook(authorId, bookId);
    bookRepository.addAuthorJoinBook(bookId, authorId);
    return authorJoinBook;
  }

  @DeleteMapping(value = "{id}")
  public Book deleteBook(@PathVariable("id") long id) {
    var foundBook = bookRepository.findById(id);

    if (foundBook.isPresent()) {
      Book book = foundBook.get();
      bookRepository.deleteById(id);
      return book;
    }

    return null;
  }
}
