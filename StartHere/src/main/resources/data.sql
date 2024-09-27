INSERT INTO section (sectionid, name) VALUES (1, 'Fiction');
INSERT INTO section (sectionid, name) VALUES (2, 'Technology');
INSERT INTO section (sectionid, name) VALUES (3, 'Travel');
INSERT INTO section (sectionid, name) VALUES (4, 'Business');
INSERT INTO section (sectionid, name) VALUES (5, 'Religion');

INSERT INTO author (authorid, fname, lname) VALUES (1, 'John', 'Mitchell');
INSERT INTO author (authorid, fname, lname) VALUES (2, 'Dan', 'Brown');
INSERT INTO author (authorid, fname, lname) VALUES (3, 'Jerry', 'Poe');
INSERT INTO author (authorid, fname, lname) VALUES (4, 'Wells', 'Teague');
INSERT INTO author (authorid, fname, lname) VALUES (5, 'George', 'Gallinger');
INSERT INTO author (authorid, fname, lname) VALUES (6, 'Ian', 'Stewart');

INSERT INTO book (bookid, title, ISBN, copy, sectionid) VALUES (1, 'Flatterland', '9780738206752', 2001, 1);
INSERT INTO book (bookid, title, ISBN, copy, sectionid) VALUES (2, 'Digital Fortess', '9788489367012', 2007, 1);
INSERT INTO book (bookid, title, ISBN, copy, sectionid) VALUES (3, 'The Da Vinci Code', '9780307474278', 2009, 1);
INSERT INTO book (bookid, title, ISBN, copy, sectionid) VALUES (4, 'Essentials of Finance', '1314241651234', NULL, 4);
INSERT INTO book (bookid, title, ISBN, copy, sectionid) VALUES (5, 'Calling Texas Home', '1885171382134', 2000, 3);

INSERT INTO wrote (bookid, authorid) VALUES (1, 6);
INSERT INTO wrote (bookid, authorid) VALUES (2, 2);
INSERT INTO wrote (bookid, authorid) VALUES (3, 2);
INSERT INTO wrote (bookid, authorid) VALUES (4, 5);
INSERT INTO wrote (bookid, authorid) VALUES (4, 3);
INSERT INTO wrote (bookid, authorid) VALUES (5, 4);

alter sequence hibernate_sequence restart with 25;