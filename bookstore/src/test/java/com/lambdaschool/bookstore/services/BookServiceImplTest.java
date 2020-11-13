package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.BookstoreApplication;
import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.models.Section;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


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
    public void a_findAll()
    { assertEquals(5, bookService.findAll().size());
    }

    @Test
    public void findBookById()
    { assertEquals("test Flatterland", bookService.findBookById(26).getTitle());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void notFindBookById()
    { assertEquals("test Flatterland", bookService.findBookById(105).getTitle());
    }

    @Test
    public void zz_delete()
    { bookService.delete(26);
      assertEquals(4, bookService.findAll().size());
    }

    @Test
    public void save()
    { String newBook = "New Book";
        Section s2 = new Section();
        Book b6 = new Book(newBook, "251557515", 2005, s2);
        bookService.save(b6);
    }

    @Test
    public void update()
    {
    }

    @Test
    public void deleteAll()
    { bookService.deleteAll();
      assertEquals(0, bookService.findAll().size());
    }
}