package com.abrahambueno.librarybooks.repositories;

import com.abrahambueno.librarybooks.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
