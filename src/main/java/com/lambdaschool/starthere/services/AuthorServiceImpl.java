package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.models.Author;

import java.util.List;


public abstract class AuthorServiceImpl implements AuthorService
{
    @Override
    public List<Author> findAll()
    {
        return null;
    }

    @Override
    public Author findAuthorById(long id)
    {
        return null;
    }

    @Override
    public List<Author> findAuthorByName(String name)
    {
        return null;
    }

    @Override
    public void delete(long id)
    {

    }

    @Override
    public Author save(Author author)
    {
        return null;
    }
}
