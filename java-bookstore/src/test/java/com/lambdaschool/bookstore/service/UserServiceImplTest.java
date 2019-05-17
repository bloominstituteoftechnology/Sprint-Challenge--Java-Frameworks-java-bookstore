package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.AuthenticatedusersApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

//FIXME How to include dependencies for userService

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthenticatedusersApplication.class)
public class UserServiceImplTest
{
    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void loadUserByUsername()
    {
        assertEquals(3, userService.findAll().size());
    }

    @Test
    public void findUserById()
    {
    }

    @Test
    public void findAll()
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
}