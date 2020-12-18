package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.BookstoreApplication;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.models.Section;
import com.lambdaschool.bookstore.services.BookService;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)

/*****
 * Due to security being in place, we have to switch out WebMvcTest for SpringBootTest
 * @WebMvcTest(value = BookController.class)
 */
@SpringBootTest(classes = BookstoreApplication.class)

/****
 * This is the user and roles we will use to test!
 */
@WithMockUser(username = "admin", roles = {"ADMIN", "DATA"})
public class BookControllerTest
{
    /******
     * WebApplicationContext is needed due to security being in place.
     */
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    List<Book> bookList = new ArrayList<>();

    @Before
    public void setUp() throws
            Exception
    {
        /*****
         * The following is needed due to security being in place!
         */
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();

        /*****
         * Note that since we are only testing bookstore data, you only need to mock up bookstore data.
         * You do NOT need to mock up user data. You can. It is not wrong, just extra work.
         */

        bookList = new ArrayList<>();

        Section s1 = new Section("Section One");
        Section s2 = new Section("Section Two");
        Section s3 = new Section("Section Three");
        Book b1 = new Book("Book One", "56194981951", 5002, s1);
        Book b2 = new Book("Book Two", "5184882984", 2065, s3);
        Book b3 = new Book("Book Three", "65489621587921", 6969, s2);

        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);
    }

    @After
    public void tearDown() throws
            Exception
    {
    }

    @Test
    public void listAllBooks() throws
            Exception
    { String apiUrl = "http://localhost:2019/books/books";
        Mockito.when(bookService.findAll()).thenReturn(bookList);

        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);
        MvcResult r = mockMvc.perform(rb).andReturn();
        String result = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String expected = mapper.writeValueAsString(bookList);

        assertEquals(expected, result);
    }

    @Test
    public void getBookById() throws
            Exception
    {
    }

    @Test
    public void getNoBookById() throws
            Exception
    {
    }

    @Test
    public void addNewBook() throws
            Exception
    {
    }

    @Test
    public void updateFullBook()
    {
    }

    @Test
    public void deleteBookById() throws
            Exception
    {
    }
}