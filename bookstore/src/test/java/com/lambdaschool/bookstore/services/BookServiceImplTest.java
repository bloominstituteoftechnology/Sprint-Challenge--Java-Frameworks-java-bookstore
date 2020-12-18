package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.BookstoreApplication;
import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Author;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.models.Section;
import com.lambdaschool.bookstore.models.Wrote;
import com.lambdaschool.bookstore.repository.AuthorRepository;
import com.lambdaschool.bookstore.repository.BookRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;


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

    @MockBean
    AuthorRepository authorrepos;

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
        Mockito.when(bookrepos.findAll()).thenReturn(bookList);
        assertEquals(2, bookService.findAll().size());
    }

    @Test
    public void findBookById()
    {
        Mockito.when(bookrepos.findById(111L)).thenReturn(Optional.of(bookList.get(0)));
        assertEquals("Flatterland", bookService.findBookById(111L).getTitle());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void notFindBookById()
    {
        Mockito.when(bookrepos.findById(1111L)).thenReturn(null);
        assertEquals("", bookService.findBookById(1110L).getTitle());
    }

    @Test
    public void delete()
    {
        assertEquals(2, bookList.size());
    }

    @Test
    public void save()
    {
        Author a1 = new Author("John", "Mitchell");
        a1.setAuthorid(10);

        Book b3 = new Book("Flatterland", "9780738206752", 2001, null);
        b3.getWrotes().add(new Wrote(a1, b3));
        b3.setBookid(0);

        Mockito.when(bookrepos.save(b3)).thenReturn(b3);
        Mockito.when(authorrepos.findById(a1.getAuthorid())).thenReturn(Optional.of(a1));


        Book addBook = bookrepos.save(b3);

        System.out.println(addBook);
        assertNotNull(addBook);

        assertEquals("Flatterland", addBook.getTitle());
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