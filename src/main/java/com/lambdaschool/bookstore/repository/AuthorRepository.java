package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository
        extends CrudRepository<Author, Long>
{
}
