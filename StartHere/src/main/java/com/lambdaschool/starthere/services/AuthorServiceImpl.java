package com.lambdaschool.starthere.services;


import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository repo;


    @Override
    public List<Author> findAll() {
        List<Author> authorList = new ArrayList<>();
        repo.findAll().iterator().forEachRemaining(authorList::add);
        return authorList;
    }
}
