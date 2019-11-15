package com.lambdaschool.usermodel.services.bookservice;


import com.lambdaschool.usermodel.models.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book update(long bookId, Book newBook);
    Book addAuthor(long bookID, long authorId);
    void delete(long bookId);
}
