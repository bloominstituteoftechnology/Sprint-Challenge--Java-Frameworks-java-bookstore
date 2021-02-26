package com.lambdaschool.bookstore.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.bookstore.BookstoreApplicationTest;
import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Author;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.models.Section;
import com.lambdaschool.bookstore.models.Wrote;
import com.lambdaschool.bookstore.repository.AuthorRepository;
import com.lambdaschool.bookstore.repository.BookRepository;
import com.lambdaschool.bookstore.repository.SectionRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WithMockUser(username = "admin",
        roles = {"USER", "ADMIN"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = BookstoreApplicationTest.class, properties = {
        "command.line.runner.enabled=false"})

public class BookServiceImplUnitTestNoDB
{

    @Autowired
    private BookService bookService;
    @MockBean
    private AuthorRepository authorrepos;

    @MockBean
    private SectionRepository sectionrepos;
    @MockBean
    private BookRepository bookrepos;

    List<Book> myBookList = new ArrayList<>();

    @Before
    public void setUp() throws
            Exception
    {

        Author a1 = new Author("John", "Mitchell");
        a1.setAuthorid(1);
        Author a2 = new Author("Dan", "Brown");
        a1.setAuthorid(2);
        Author a3 = new Author("Jerry", "Poe");
        a1.setAuthorid(3);
        Author a4 = new Author("Wells", "Teague");
        a1.setAuthorid(4);
        Author a5 = new Author("George", "Gallinger");
        a1.setAuthorid(5);
        Author a6 = new Author("Ian", "Stewart");
        a1.setAuthorid(6);

        Section s1 = new Section("Fiction");
        s1.setSectionid(1);
        Section s2 = new Section("Technology");
        s2.setSectionid(2);
        Section s3 = new Section("Travel");
        s3.setSectionid(3);
        Section s4 = new Section("Business");
        s4.setSectionid(4);
        Section s5 = new Section("Religion");
        s5.setSectionid(5);

        Book b1 = new Book("Flatterland", "9780738206752", 2001, s1);
        b1.setBookid(1);
        b1.getWrotes()
            .add(new Wrote(a6, b1));
        myBookList.add(b1);

        Book b2 = new Book("Digital Fortess", "9788489367012", 2007, s1);
        b2.setBookid(2);
        b2.getWrotes()
            .add(new Wrote(a2, b2));
        myBookList.add(b2);

        Book b3 = new Book("The Da Vinci Code", "9780307474278", 2009, s1);
        b3.setBookid(3);
        b3.getWrotes()
            .add(new Wrote(a2, b3));
        myBookList.add(b3);

        Book b4 = new Book("Essentials of Finance", "1314241651234", 0, s4);
        b4.setBookid(4);
        b4.getWrotes()
            .add(new Wrote(a3, b4));
        b4.getWrotes()
            .add(new Wrote(a5, b4));
        myBookList.add(b4);

        Book b5 = new Book("Calling Texas Home", "1885171382134", 2000, s3);
        b5.setBookid(5);
        b5.getWrotes()
            .add(new Wrote(a4, b5));
        myBookList.add(b5);

        System.out.println("Size " + myBookList.size());
        for (Book b : myBookList)
        {
            System.out.println(b);
        }

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
        Mockito.when(bookrepos.findAll()).thenReturn(myBookList);
        assertEquals(5, bookService.findAll().size());
    }

    @Test
    public void findBookById()
    {
       Mockito.when(bookrepos.findById(2L)).thenReturn(Optional.of(myBookList.get(1)));
       assertEquals("Digital Fortess", bookService.findBookById(2).getTitle());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void notFindBookById()
    {
        Mockito.when(bookrepos.findById(12542L)).thenThrow(ResourceNotFoundException.class);
        assertEquals("The Da Vinci Code", bookService.findBookById(12542).getTitle());

    }

    @Test
    public void delete()
    {
        Mockito.when(bookrepos.findById(3L))
                .thenReturn(Optional.of(myBookList.get(0)));
        Mockito.doNothing()
                .when(bookrepos)
                .deleteById(3L);

        bookService.delete(3);
        assertEquals(5, myBookList.size());
    }

    @Test
    public void save()
    {

        Author a1 = new Author("John", "Mitchell");
        a1.setAuthorid(1);
        String nameBook = "Strange book";
        Section s1 = new Section("Fiction");
        s1.setSectionid(1);
        Book b3 = new Book("Strange book", "9780307474278", 2019,s1);
        b3.getWrotes().add(new Wrote(a1,new Book()));


        Mockito.when(bookrepos.save(any(Book.class))).thenReturn(b3);
        Mockito.when(sectionrepos.findById(1L)).thenReturn(Optional.of(s1));
        Mockito.when(authorrepos.findById(1L)).thenReturn(Optional.of(a1));
        b3 = bookService.save(b3);
        System.out.println(b3);
        assertNotNull(b3);
        assertEquals(nameBook, b3.getTitle());

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