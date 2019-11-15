package com.lambdaschool.usermodel.services.authorservice;

import com.lambdaschool.usermodel.models.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> findAllAuthors();
}
