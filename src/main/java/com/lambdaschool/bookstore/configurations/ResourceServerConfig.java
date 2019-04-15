package com.lambdaschool.bookstore.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
  private static final String RESOURCE_ID = "resource_id";

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) {
    resources.resourceId(RESOURCE_ID).stateless(false);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.
      anonymous().disable()
      .authorizeRequests()
      .antMatchers("/data/**").access("hasRole('ROLE_DATA')")
      .antMatchers("/users/**").access("hasRole('ROLE_MGR')")
      .antMatchers("/books/**").access("hasAnyRole('ROLE_USER', 'ROLE_DATA', 'ROLE_MGR')")
      .antMatchers("/authors/**").access("hasAnyRole('ROLE_USER', 'ROLE_DATA', 'ROLE_MGR')")
      .antMatchers("/sections/**").access("hasAnyRole('ROLE_USER', 'ROLE_DATA', 'ROLE_MGR')")
      .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
  }
}
