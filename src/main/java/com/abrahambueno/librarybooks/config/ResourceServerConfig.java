package com.abrahambueno.librarybooks.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter
{

    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources)
    {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

//    @Override
//    public void configure(HttpSecurity http) throws Exception
//    {
//        http.
//                anonymous().disable()
//                .authorizeRequests()
//                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
////                .antMatchers("/users/**").access("hasRole('ROLE_ADMIN')")
////                .antMatchers("/courses/**").access("hasRole('ROLE_USER')")
////                .antMatchers("/students/**").access("hasRole('ROLE_USER')")
//                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
//    }

    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers("/users/**").access("hasAnyRole('ROLE_MGR')")
                .antMatchers("/data/**").access("hasAnyRole('ROLE_DATA')")
                .antMatchers("/authors/**").access("hasAnyRole('ROLE_MGR','ROLE_USER')")
                .antMatchers("/books/**").access("hasAnyRole('ROLE_MGR','ROLE_USER')")
                .antMatchers("/sections/**").access("hasAnyRole('ROLE_MGR','ROLE_USER')")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}