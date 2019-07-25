# java-bookstore

## Introduction

This is a bookstore with books who have authors and can be found in a section of the store.

## Instructions

The provided initial application has the basics in place for
* User Oauth2 Authentication
* Exception Handling
* Swagger
* Logging 
* Unit / Integration testing (at least the POM file entries)
* Deployment to Heroku
* Conversion to Postgresql

Starting with this initial application: https://github.com/LambdaSchool/java-starthere.git 

Create a REST API server to store and read data from a PostgreSQL Database. The table layouts should be

* book
  * bookid - long primary key
  * booktitle - String the title of the book
  * ISBN - String the ISBN number of the book
  * copy - Int the year the book was published (copyright date)
  
* authors
  * authorid - long primary key
  * lastname - String last name of the author
  * firstname - String first name of the author

There is a many to many relationship between authors and books. A book may have many authors while an author may write many books.

* Add audit fields to both tables.

* data.sql contains sample data to test your application. It is ok that on the initial load of the data, the audit fields are null.

* You bookstore endpoints should have customized Swagger documentation. 

* Appropriate Exception handling should be in place for each bookstore endpoint

* The bookstore endpoints should be pageable and sortable.

* List the data

  * GET /books - returns a JSON object list of all the books and their authors.
  
  * GET /authors - returns a JSON object list of all the authors and their books.

* Manage the data

  * PUT /data/books/{id} - updates a books info (Title, Copyright, ISBN) but does NOT have to assign authors to the books.

  * POST /data/books/{bookid}/authors/{authorid} - assigns a book already in the system (bookid) to an author already in the system (authorid) (see how roles are handled for users)

  * DELETE /data/books/{id} - deletes a book and the book author combinations - but does not delete the author records.
 
Your system will have authentication in place. The following are the roles you need to handle:

* User - people who can look up books, authors

* Data - people who can update data on books, authors, sections. The can also read books, authors, sections.

* ADMIN - people who can update data on users and otherwise have full access to the system.

* Make sure that actuator endpoints are exposed

### Deploy the system to Heroku!

Note that several obvious end points are not included in the required list. Finishing out the list of useful end points is the stretch goal. You are to decide what those end points are!
