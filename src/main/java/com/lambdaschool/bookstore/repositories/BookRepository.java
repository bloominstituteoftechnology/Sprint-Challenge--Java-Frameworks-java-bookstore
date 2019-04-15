package com.lambdaschool.bookstore.repositories;

import com.lambdaschool.bookstore.models.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface BookRepository extends BaseJpaRepository<Book> {
  @Transactional
  @Modifying
  @Query(value = "INSERT INTO authors_join_books (book_id, author_id) " +
    "VALUES(:bookId, :authorId)", nativeQuery = true)
  void addAuthorJoinBook(long bookId, long authorId);
}
