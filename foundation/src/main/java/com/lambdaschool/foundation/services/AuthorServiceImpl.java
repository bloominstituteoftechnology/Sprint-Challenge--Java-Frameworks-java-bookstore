package com.lambdaschool.foundation.services;


import com.lambdaschool.foundation.models.Author;
import com.lambdaschool.foundation.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService
{
  @Autowired
  private AuthorRepository authorrepos;

  @Override
  public ArrayList<Author> findAll(Pageable pageable)
  {
    ArrayList<Author> list = new ArrayList<>();
    authorrepos.findAll(pageable).iterator().forEachRemaining(list::add);
    return list;
  }

  @Override
  public Author save(Author author) {
    return null;
  }
}
