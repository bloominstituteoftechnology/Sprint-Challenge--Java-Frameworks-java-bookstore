package com.lambdaschool.bookstore.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.bookstore.BookstoreApplication;
import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Author;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.models.Section;
import com.lambdaschool.bookstore.models.Wrote;
import com.lambdaschool.bookstore.repository.BookRepository;
import com.lambdaschool.bookstore.services.BookService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    }

    @After
    public void tearDown() throws
            Exception
    {
    }

    @Test
    public void listAllBooks() throws
            Exception
    {
        //Create API url
        String apiUrl = "/books/books";

        //Mock findAll
        Mockito.when(bookService.findAll()).thenReturn(bookList);

        //Make request builder
        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);

        //Perform request
        MvcResult result = mockMvc.perform(rb).andReturn();

        //Save result as a string
        String testResult = result.getResponse().getContentAsString();

        //Convert
        ObjectMapper mapper = new ObjectMapper();
        String expectedResult = mapper.writeValueAsString(bookList);

        assertEquals(expectedResult, testResult);
    }

    @Test
    public void getBookById() throws
            Exception
    {
        //Create API url
        String apiUrl = "/books/book/111";

        //Mock findAll
        Mockito.when(bookService.findBookById(111L)).thenReturn(bookList.get(0));

        //Make request builder
        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);

        //Perform request
        MvcResult result = mockMvc.perform(rb).andReturn();

        //Save result as a string
        String testResult = result.getResponse().getContentAsString();

        //Convert
        ObjectMapper mapper = new ObjectMapper();
        String expectedResult = mapper.writeValueAsString(bookList.get(0));


        assertEquals(expectedResult, testResult);

        Mockito.when(bookService.findBookById(any(Long.class))).thenReturn(bookList.get(0));
        assertEquals("Flatterland", bookService.findBookById(111L).getTitle());
    }

    @Test
    public void getNoBookById() throws
            Exception
    {
        //Create API url
        String apiUrl = "/books/book/1111";

        //Mock findAll
        Mockito.when(bookService.findBookById(1111L)).thenReturn(null);

        //Make request builder
        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);

        //Perform request
        MvcResult result = mockMvc.perform(rb).andReturn();

        //Save result as a string
        String testResult = result.getResponse().getContentAsString();

        //Convert
        ObjectMapper mapper = new ObjectMapper();
        String expectedResult = "";

        assertEquals(expectedResult, testResult);
    }

    @Test
    public void addNewBook() throws
            Exception
    {
        //Create API url
        String apiUrl = "/books/book/";

        //Mock findAll
        Mockito.when(bookService.save(any(Book.class))).thenReturn(bookList.get(0));

        //Convert
        ObjectMapper mapper = new ObjectMapper();
        String bookAsString = mapper.writeValueAsString(bookList.get(0));

        //Make request builder
        RequestBuilder rb = MockMvcRequestBuilders.post(apiUrl)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookAsString);

        //Perform request
       mockMvc.perform(rb).andExpect(status().isCreated());
    }

    @Test
    public void updateFullBook()
    {
    }

    @Test
    public void deleteBookById() throws
            Exception
    {
        //Create API url
        String apiUrl = "/books/book/111";

        //Make request builder
        RequestBuilder rb = MockMvcRequestBuilders.delete(apiUrl).accept(MediaType.APPLICATION_JSON);

        //Perform request
        mockMvc.perform(rb).andExpect(status().isOk());
    }
}