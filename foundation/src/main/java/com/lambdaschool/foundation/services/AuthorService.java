package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Author;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface AuthorService
{
  ArrayList<Author> findAll(Pageable pageable);
  Author save(Author author);
}
