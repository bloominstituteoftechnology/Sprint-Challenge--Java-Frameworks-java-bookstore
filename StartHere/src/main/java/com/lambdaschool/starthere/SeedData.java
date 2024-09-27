package com.lambdaschool.starthere;

import com.lambdaschool.starthere.models.*;
import com.lambdaschool.starthere.services.AuthorService;
import com.lambdaschool.starthere.services.BookService;
import com.lambdaschool.starthere.services.RoleService;
import com.lambdaschool.starthere.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;



    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);

        // admin, data, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        admins.add(new UserRoles(new User(), r3));
        User u1 = new User("admin", "password", admins);
        u1.getQuotes().add(new Quote("A creative man is motivated by the desire to achieve, not by the desire to beat others", u1));
        u1.getQuotes().add(new Quote("The question isn't who is going to let me; it's who is going to stop me.", u1));
        userService.save(u1);

        // data, user
        ArrayList<UserRoles> datas = new ArrayList<>();
        datas.add(new UserRoles(new User(), r3));
        datas.add(new UserRoles(new User(), r2));
        User u2 = new User("cinnamon", "1234567", datas);
        userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("barnbarn", "ILuvM4th!", users);
        u3.getQuotes().add(new Quote("Live long and prosper", u3));
        u3.getQuotes().add(new Quote("The enemy of my enemy is the enemy I kill last", u3));
        u3.getQuotes().add(new Quote("Beam me up", u3));
        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("Bob", "password", users);
        userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("Jane", "password", users);
        userService.save(u5);

        Author a1 = new Author("Mitchell", "John");
        Author a2 = new Author("Brown", "Dan");
        Author a3 = new Author("Poe", "Jerry");
        Author a4 = new Author("Teague", "Wells");
        Author a5 = new Author("Gallinger", "George");
        Author a6 = new Author("Stewart", "Ian");

        authorService.save(a1);
        authorService.save(a2);
        authorService.save(a3);
        authorService.save(a4);
        authorService.save(a5);
        authorService.save(a6);

        Book b1 = new Book("Flatterland", "9780738206752", "2001", new ArrayList<>(Arrays.asList(a6)));
        Book b2 = new Book("Digital Fortess", "9788489367012", "2007", new ArrayList<>(Arrays.asList(a2)));
        Book b3 = new Book("The Da Vinci Code", "9780307474278", "2009", new ArrayList<>(Arrays.asList(a2)));
        Book b4 = new Book("Essentials of Finance", "1314241651234", null, new ArrayList<>(Arrays.asList(a5, a3)));
        Book b5 = new Book("Calling Texas Home", "1885171382134", "2000", new ArrayList<>(Arrays.asList(a4)));

        bookService.save(b1);
        bookService.save(b2);
        bookService.save(b3);
        bookService.save(b4);
        bookService.save(b5);
    }
}