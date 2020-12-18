package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.BookstoreApplication;
import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookstoreApplication.class)
//**********
// Note security is handled at the controller, hence we do not need to worry about security here!
//**********
public class BookServiceImplTest
{

    @Autowired
    private BookService bookService;

    @Before
    public void setUp() throws
                        Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws
                           Exception
    {
    }

    @Test
    public void findAll()
    {
        assertEquals(5, bookService.findAll().size());
    }

    @Test
    public void findBookById()
    {
        assertEquals("Digital Fortress", bookService.findBookById(2).getName());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void notFindBookById()
    {
        assertEquals("Digital Fortress", bookService.findBookById(202).getName());
    }

    @Test
    public void delete()
    {
        bookService.delete(3);
        assertEquals(2, bookService.findAll().size());
    }

    @Test
    public void save()
    {
        String b1Name = "this testing book";
        Book b1 = new Book("Flatterland", "9780738206752", 2001, s1);
        b1.setWrotes(wrote);

        Book addBook = bookService.save(b1);
        assertNotNull(addBook);
        assertEquals(b1Name, addBook.getName());
    }

    @Test
    public void update()
    {
    }

    @Test
    public void deleteAll()
    {
    }
}