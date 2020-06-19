package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Book;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public interface BookService
{
  List<Book> findAll();

  Book update(Book book, long id);

  void addBookToAuthor(long bookid, long authorid);

  void delete(long id);

  Book save (Book book);
}
