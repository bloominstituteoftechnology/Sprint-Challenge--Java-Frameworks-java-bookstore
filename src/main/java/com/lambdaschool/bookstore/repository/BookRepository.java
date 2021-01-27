package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository
        extends CrudRepository<Book, Long>
{
}
