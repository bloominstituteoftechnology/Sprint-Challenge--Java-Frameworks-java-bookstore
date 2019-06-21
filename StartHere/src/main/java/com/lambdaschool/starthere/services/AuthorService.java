package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Author;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService {

    List<Author> findAll(Pageable pageable);

    void save(Author author);
}
