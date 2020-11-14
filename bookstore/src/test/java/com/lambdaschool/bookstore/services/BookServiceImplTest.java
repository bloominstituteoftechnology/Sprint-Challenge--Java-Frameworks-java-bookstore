package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.BookstoreApplication;
import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Author;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.models.Section;
import com.lambdaschool.bookstore.models.Wrote;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookstoreApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//**********
// Note security is handled at the controller, hence we do not need to worry about security here!
//**********
public class BookServiceImplTest{
    @MockBean
    HelperFunctions helperFunctions;

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
    public void findAll(){
        assertEquals(5,bookService.findAll().size());
    }

    @Test
    public void findBookById(){
        assertEquals("The Da Vinci Code",bookService.findBookById(3).getTitle());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void notFindBookById()
    {
        assertEquals("The Da Vinci Code", bookService.findBookById(10).getTitle());
    }

    @Test
    public void x_delete(){
        bookService.delete(5);
        assertEquals(4, bookService.findAll().size());
    }

    @Test
    public void y_save(){
        Author a4 = new Author("Wells", "Teague");
        Section s3 = new Section("Travel");
        Book b5 = new Book("Calling Texas Home", "1885171382134", 2000, s3);
        b5.getWrotes()
                .add(new Wrote(a4, new Book()));
        b5 = bookService.save(b5);
        assertNotNull(b5);
        assertEquals(5, b5.getBookid());
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