package com.lambdaschool.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//@EnableWebMvc
//@EnableJpaAuditing
//@SpringBootApplication
public class AuthenticatedusersApplication
{

    public static void main(String[] args)
    {
        ApplicationContext ctx = SpringApplication.run(AuthenticatedusersApplication.class, args);

        DispatcherServlet dispatcherServlet = (DispatcherServlet)ctx.getBean("dispatcherServlet");
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
    }
}
