package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.BookstoreApplication;
import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Author;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.models.Section;
import com.lambdaschool.bookstore.models.Wrote;
import com.lambdaschool.bookstore.repository.BookRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private AuthorService authorService;

    @Autowired
    private SectionService sectionService;

    @MockBean
    BookRepository bookrepos;

    //Mock up database
    private List<Book> bookList = new ArrayList<>();

    @Before
    public void setUp() throws
            Exception
    {
        //Mock Up Data
        Author a1 = new Author("John", "Mitchell");
        Author a2 = new Author("Dan", "Brown");
        a1.setAuthorid(10);
        a2.setAuthorid(20);

        Section s1 = new Section("Fiction");
        Section s2 = new Section("Technology");
        s1.setSectionid(11);
        s2.setSectionid(12);

        Book b1 = new Book("Flatterland", "9780738206752", 2001, s1);
        b1.getWrotes().add(new Wrote(a1, new Book()));
        b1.setBookid(111);

        Book b2 = new Book("Digital Fortess", "9788489367012", 2007, s1);
        b2.getWrotes().add(new Wrote(a2, new Book()));
        b2.setBookid(222);

        bookList.add(b1);
        bookList.add(b2);

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
//        Mockito.when(bookrepos.findAll()).thenReturn(bookList);
//        assertEquals(2, bookService.findAll().size());
    }

    @Test
    public void findBookById()
    {
    }

    @Test(expected = ResourceNotFoundException.class)
    public void notFindBookById()
    {
    }

    @Test
    public void delete()
    {
    }

    @Test
    public void save()
    {
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