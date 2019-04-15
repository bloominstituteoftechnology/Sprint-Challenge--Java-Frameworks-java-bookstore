DELETE FROM authors_join_books;
DELETE FROM books;
DELETE FROM sections;
DELETE FROM authors;
DELETE FROM users;

INSERT INTO users (user_id, username, password, role)
  VALUES(1, 'user', 'pass', 'user'),
        (2, 'data', 'pass', 'data'),
        (3, 'mgr', 'pass', 'mgr');

INSERT INTO authors (author_id, last_name, first_name)
  VALUES(1, 'Wrightington', 'Sir'),
        (2, 'Wreadington', 'Ma\'am'),
        (3, 'Willington', 'Perl');

INSERT INTO sections (section_id, name)
VALUES(1, 'Book-oriented'),
      (2, 'Programming');

INSERT INTO books (book_id, title, isbn, copy, section_id)
  VALUES(1, 'How to write lots of books', '00000000', 1972),
        (2, 'How to read lots of books', '00000004', 1984),
        (3, 'Scripting with Perl', '00000005', 2018),
        (4, 'Advanced Perl scripting', '00000006', 2019);

INSERT INTO authors_join_books (author_id, book_id)
  VALUES(1, 1),
        (2, 2),
        (3, 3),
        (3, 4);
