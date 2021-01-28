# Java Frameworks Sprint Challenge

**Read these instructions carefully. Understand exactly what is expected _before_ starting this Sprint Challenge.**

This challenge allows you to practice the concepts and techniques learned over the past sprint and apply them in a concrete project. This sprint explored **using Frameworks in Java**. During this sprint, you studied **Exception Handling, User Authentication, Automated Testing, and Deployment**. In your challenge this week, you will demonstrate your mastery of these skills by creating **a Java Spring REST API Application**.

This is an individual assessment. All work must be your own. Your challenge score is a measure of your ability to work independently using the material covered through this sprint. You need to demonstrate proficiency in the concepts and objectives introduced and practiced in preceding days.

You are not allowed to collaborate during the sprint challenge. However, you are encouraged to follow the twenty-minute rule and seek support from your TL if you need direction.

_You have **three hours** to complete this challenge. Plan your time accordingly._

## Introduction

This is a basic bookstore database scheme with books that have authors. Books may have many authors and many authors may have written many books. The relationship between books and authors is called `wrote`. Each book can be found in only one section of the bookstore. 

### Commits

Commit your code regularly and meaningfully. This helps both you (in case you ever need to return to old code for any number of reasons) and your project reviewers as they evaluate your code.

## Interview Questions

Be prepared to demonstrate your understanding of this week's concepts by answering questions on the following topics.

1. Explain exception handling in your application.
2. Explain your user authentication flow.
3. Explain your unit tests, including how they work and why they are important.
4. Explain how you deployed your application to a cloud service with a persistent database.

## Instructions

### Task 1: Project Set Up

- [ ] Create a forked copy of this project
- [ ] Clone your OWN version of the repository (Not Lambda's by mistake!)
- [ ] Create a new branch: git checkout -b `<firstName-lastName>`.
- [ ] Start with the provided bookstore application.
- [ ] Push commits: `git push -u origin <firstName-lastName>`
- [ ] Implement the project on your newly created `<firstName-lastName>` branch, committing changes regularly

#### Video on How to Set Up Your Project

[![Video on how to set up your project](https://img.youtube.com/vi/Bw55xlQGQoQ/0.jpg)](https://youtu.be/Bw55xlQGQoQ)

### Task 2: Project Requirements

- [ ] You will be creating a REST api service to store and read data from a database. You should be able to switch between an H2 database and a PostgreSQL database by using an application.properties setting.

- [ ] Please fork and clone this repository. This repository does have a starter project. The provided initial application has the basics in place. Note that if you start with the initial project, all the following are done for you!!!

- Auditing fields
- Exception Handling
- User Oauth2 Authentication
  - Endpoints to handle (know how these work)
    - Creating a new user
    - Updating a user
    - Deleting a user
    - Authenticated user logging out
    - plus many more!
- Swagger
- Unit / Integration testing (at least the POM file entries and general structure)
- The database is already modeled for you
- [ ] Do NOT change or delete entries in the POM.XML - Dependencies, plugins, etc. may be added as needed

![Bookstore Database](bookstoredb.png)

- **You are tasked to do the following**

- [ ] Currently, Books are not addressed in security so those routes cannot be accessed. Setup security so that the following access is available:
  - [ ] GET /books/books - any user with the role ADMIN, USER, or DATA can access
  - [ ] GET /books/book/{id} - any user with role ADMIN, USER, or DATA can access
  - [ ] POST /books/book - any user with role ADMIN can access
  - [ ] PUT /books/book/{id} - any user with role ADMIN can access
  - [ ] DELETE /books/book/{id} - any user with role ADMIN can access

- [ ] When a client tries searching for or updating a book that does not exist, a generic exception is sent back to the client. Change this so our custom exception `ResourceNotFoundException` is returned instead.

- [ ] Add unit test for the Book Service without using the database as test data. The structure is already in place, you need to write the tests for the following:
  - [ ] findAll
  - [ ] findBookById that succeeds
  - [ ] findBookById that fails
  - [ ] delete
  - [ ] save a new book

- [ ] Add unit tests for the Book Controller NOT relying on the database as test data. The structure is already in place, you need to set up the data and write the tests for the following:
  - [ ] listAllBooks
  - [ ] getBookById that succeeds
  - [ ] getBookById that fails
  - [ ] addNewBook
  - [ ] deleteBookById

- [ ] And now that we have a good system, deploy the system to Heroku using PostgreSQL. Your application should be switchable between H2 and PostgreSQL through setting a variable in application.properties

### Required best practices

- [ ] Consistent naming. Examples: variables, functions, Components, and file/folder organization.
- [ ] Consistent spacing. Examples: line breaks, around arguments and before/after functions.
- [ ] Consistent quotation usage.
- [ ] Spell-check.
- [ ] Schedule time to review, refine and reassess your work.

It is better to submit a challenge that meets [MVP](https://en.wikipedia.org/wiki/Minimum_viable_product) than one that attempts too much and fails.

### Tips and Gotchas

In your solution, it is essential that you follow best practices and produce clean and professional results. You will be scored on your adherence to proper code style and good organization. Schedule time to review, refine, and assess your work and perform basic professional polishing including spell-checking and grammar-checking on your work. It is better to submit a challenge that meets MVP than one that attempts too much and does not.

### Task 3: Stretch Goals

- [ ] Unit Testing
  - [ ] Write tests to achieve 100% line coverage in book service. This can be done either with or without connecting to the database.
  - [ ] Write tests to achieve 100% line coverage in book controller. This can be done either with or without connecting to the database.

## Submission format

Follow these steps for completing your project.

- [ ] Set up your fork on Github to submit via Codegrade, pushing commits to your <firstName-lastName> branch.

## A summary of requirements

### MVP

- Implement Security For the routes
  - GET /books/books
  - GET /books/book/{id}
  - POST /books/book
  - PUT /books/book/{id}
  - DELETE /books/book/{id}

- Testing the methods

  - Book Service:
    - findAll
    - findBookById that succeeds
    - findBookById that fails
    - delete
    - save a new book

  - Book Controller:
    - listAllBooks
    - getBookById that succeeds
    - getBookById that fails
    - addNewBook
    - deleteBookById

- Use custom exception handlers

- Deploy to Heroku using PostgreSQL
