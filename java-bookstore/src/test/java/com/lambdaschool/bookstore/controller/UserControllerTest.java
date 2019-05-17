package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.model.User;
import com.lambdaschool.bookstore.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private List<User> userList;

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void listAllUsers()
    {
    }

    @Test
    public void getUser()
    {
    }

    @Test
    public void getCurrentUserName()
    {
    }

    @Test
    public void addNewUser()
    {
    }

    @Test
    public void updateUser()
    {
    }

    @Test
    public void deleteUserById()
    {
    }
}