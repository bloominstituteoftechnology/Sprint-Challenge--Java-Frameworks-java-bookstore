package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;


import java.awt.print.Pageable;
import java.util.List;

public interface AuthorService
{
    List<Author> findAll(Pageable pageable);
    void save(Author author);
}
