package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.models.Book;

import java.util.List;


public interface BookService
{
    List<Book> findAll();

    Book findBookById(long id);

    List<Book> getBook(String title);

    void delete(long id);

    Book save(Book book);
}
