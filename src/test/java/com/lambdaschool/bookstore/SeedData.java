package com.lambdaschool.bookstore;

import com.lambdaschool.bookstore.models.Author;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.models.Role;
import com.lambdaschool.bookstore.models.Section;
import com.lambdaschool.bookstore.models.User;
import com.lambdaschool.bookstore.models.UserRoles;
import com.lambdaschool.bookstore.models.Useremail;
import com.lambdaschool.bookstore.models.Wrote;
import com.lambdaschool.bookstore.services.AuthorService;
import com.lambdaschool.bookstore.services.BookService;
import com.lambdaschool.bookstore.services.RoleService;
import com.lambdaschool.bookstore.services.SectionService;
import com.lambdaschool.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * SeedData puts both known and random data into the database. It implements CommandLineRunner.
 * <p>
 * CoomandLineRunner: Spring Boot automatically runs the run method once and only once
 * after the application context has been loaded.
 */
@Transactional
@ConditionalOnProperty(
    prefix = "command.line.runner",
    value = "enabled",
    havingValue = "true",
    matchIfMissing = true)
@Component
public class SeedData
        implements CommandLineRunner
{
    /**
     * Connects the Role Service to this process
     */
    @Autowired
    RoleService roleService;

    /**
     * Connects the user service to this process
     */
    @Autowired
    UserService userService;

    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;

    @Autowired
    SectionService sectionService;

    /**
     * Generates test, seed data for our application
     * First a set of known data is seeded into our database.
     * Second a random set of data using Java Faker is seeded into our database.
     * Note this process does not remove data from the database. So if data exists in the database
     * prior to running this process, that data remains in the database.
     *
     * @param args The parameter is required by the parent interface but is not used in this process.
     */
    @Transactional
    @Override
    public void run(String[] args) throws
            Exception
    {
        userService.deleteAll();
        roleService.deleteAll();
        authorService.deleteAll();
        bookService.deleteAll();
        sectionService.deleteAll();

        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        r1 = roleService.save(r1);
        r2 = roleService.save(r2);
        r3 = roleService.save(r3);

        // admin, data, user
        User u1 = new User("admin",
                           "password",
                           "admin@lambdaschool.local");
        u1.getRoles()
                .add(new UserRoles(u1, r1));
        u1.getRoles()
                .add(new UserRoles(u1, r2));
        u1.getRoles()
                .add(new UserRoles(u1, r3));
        u1.getUseremails()
                .add(new Useremail(u1,
                                   "admin@email.local"));
        u1.getUseremails()
                .add(new Useremail(u1,
                                   "admin@mymail.local"));

        userService.save(u1);

        // data, user
        User u2 = new User("cinnamon",
                           "1234567",
                           "cinnamon@lambdaschool.local");
        u2.getRoles()
                .add(new UserRoles(u2, r2));
        u2.getRoles()
                .add(new UserRoles(u2, r3));
        u2.getUseremails()
                .add(new Useremail(u2,
                                   "cinnamon@mymail.local"));
        u2.getUseremails()
                .add(new Useremail(u2,
                                   "hops@mymail.local"));
        u2.getUseremails()
                .add(new Useremail(u2,
                                   "bunny@email.local"));
        userService.save(u2);

        // user
        User u3 = new User("barnbarn",
                           "ILuvM4th!",
                           "barnbarn@lambdaschool.local");
        u3.getRoles()
                .add(new UserRoles(u3, r2));
        u3.getUseremails()
                .add(new Useremail(u3,
                                   "barnbarn@email.local"));
        userService.save(u3);

        User u4 = new User("puttat",
                           "password",
                           "puttat@school.lambda");
        u4.getRoles()
                .add(new UserRoles(u4, r2));
        userService.save(u4);

        User u5 = new User("misskitty",
                           "password",
                           "misskitty@school.lambda");
        u5.getRoles()
                .add(new UserRoles(u5, r2));
        userService.save(u5);

        /************
         * Seed Books
         ************/

        Author a1 = new Author("John", "Mitchell");
        Author a2 = new Author("Dan", "Brown");
        Author a3 = new Author("Jerry", "Poe");
        Author a4 = new Author("Wells", "Teague");
        Author a5 = new Author("George", "Gallinger");
        Author a6 = new Author("Ian", "Stewart");

        a1 = authorService.save(a1);
        a2 = authorService.save(a2);
        a3 = authorService.save(a3);
        a4 = authorService.save(a4);
        a5 = authorService.save(a5);
        a6 = authorService.save(a6);

        Section s1 = new Section("Fiction");
        Section s2 = new Section("Technology");
        Section s3 = new Section("Travel");
        Section s4 = new Section("Business");
        Section s5 = new Section("Religion");

        s1 = sectionService.save(s1);
        s2 = sectionService.save(s2);
        s3 = sectionService.save(s3);
        s4 = sectionService.save(s4);
        s5 = sectionService.save(s5);

        Book b1 = new Book("Flatterland", "9780738206752", 2001, s1);
        b1.getWrotes()
                .add(new Wrote(a6, new Book()));
        b1 = bookService.save(b1);

        Book b2 = new Book("Digital Fortess", "9788489367012", 2007, s1);
        b2.getWrotes()
                .add(new Wrote(a2, new Book()));
        b2 = bookService.save(b2);

        Book b3 = new Book("The Da Vinci Code", "9780307474278", 2009, s1);
        b3.getWrotes()
                .add(new Wrote(a2, new Book()));
        b3 = bookService.save(b3);

        Book b4 = new Book("Essentials of Finance", "1314241651234", 0, s4);
        b4.getWrotes()
                .add(new Wrote(a3, new Book()));
        b4.getWrotes()
                .add(new Wrote(a5, new Book()));
        b4 = bookService.save(b4);

        Book b5 = new Book("Calling Texas Home", "1885171382134", 2000, s3);
        b5.getWrotes()
                .add(new Wrote(a4, new Book()));
        b5 = bookService.save(b5);

//        System.out.println("***** BOOK IDs *****");
//        System.out.println(b1.getTitle() + " " + b1.getBookid());
//        System.out.println(b2.getTitle() + " " + b2.getBookid());
//        System.out.println(b3.getTitle() + " " + b3.getBookid());
//        System.out.println(b4.getTitle() + " " + b4.getBookid());
//        System.out.println(b5.getTitle() + " " + b5.getBookid());
//
//        System.out.println();
//        System.out.println("***** Section Ids *****");
//        System.out.println(s1.getName() + " " + s1.getSectionid());
//        System.out.println(s2.getName() + " " + s2.getSectionid());
//        System.out.println(s3.getName() + " " + s3.getSectionid());
//        System.out.println(s4.getName() + " " + s4.getSectionid());
//        System.out.println(s5.getName() + " " + s5.getSectionid());
//
//        System.out.println();
//        System.out.println("***** Author Ids *****");
//        System.out.println(a1.getFname() + " " + a1.getLname() + " " + a1.getAuthorid());
//        System.out.println(a2.getFname() + " " + a2.getLname() + " " + a2.getAuthorid());
//        System.out.println(a3.getFname() + " " + a3.getLname() + " " + a3.getAuthorid());
//        System.out.println(a4.getFname() + " " + a4.getLname() + " " + a4.getAuthorid());
//        System.out.println(a5.getFname() + " " + a5.getLname() + " " + a5.getAuthorid());
//        System.out.println(a6.getFname() + " " + a6.getLname() + " " + a6.getAuthorid());
    }
}