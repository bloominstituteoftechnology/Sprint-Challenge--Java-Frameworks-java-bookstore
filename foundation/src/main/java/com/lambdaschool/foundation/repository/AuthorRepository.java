package com.lambdaschool.foundation.repository;

import com.lambdaschool.foundation.models.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long>
{
}
