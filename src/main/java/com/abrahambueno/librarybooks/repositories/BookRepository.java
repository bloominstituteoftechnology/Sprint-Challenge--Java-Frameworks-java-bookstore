package com.abrahambueno.librarybooks.repositories;

import com.abrahambueno.librarybooks.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
//    @Query(value = "select  a.firstname, a.lastname, b.booktitle from author a, book b, section, wrote w where w.bookid = b.bookid", nativeQuery = true)
//    List<Object[]> getAllBy();
}
