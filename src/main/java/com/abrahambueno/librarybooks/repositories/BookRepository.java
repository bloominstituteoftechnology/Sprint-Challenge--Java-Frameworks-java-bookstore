package com.abrahambueno.librarybooks.repositories;

import com.abrahambueno.librarybooks.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Transactional
    @Modifying
    // wrote table, authorid, bookid
    @Query(value = "insert into wrote (bookid, authorid) values (:bookid, :authorid)", nativeQuery = true)
    void setBookAuthors(long bookid, long authorid);
}
