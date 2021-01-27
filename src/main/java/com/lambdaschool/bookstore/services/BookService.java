package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.models.Book;

import java.util.List;

public interface BookService
{
    List<Book> findAll();

    Book findBookById(long id);

    void delete(long id);

    Book save(Book role);

    Book update(Book role,
                long id);

    void deleteAll();
}