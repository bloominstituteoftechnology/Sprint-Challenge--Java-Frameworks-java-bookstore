package com.abrahambueno.librarybooks.repositories;

import com.abrahambueno.librarybooks.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
