package com.lambdaschool.bookstore.models.transactional;

import lombok.Data;

@Data
public class AuthorJoinBook {
  private long authorId;
  private long bookId;

  public AuthorJoinBook(long authorId, long bookId) {
    this.authorId = authorId;
    this.bookId = bookId;
  }
}
