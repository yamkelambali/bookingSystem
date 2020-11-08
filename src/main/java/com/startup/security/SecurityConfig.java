package com.startup.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String ADMIN_ROLE = "ADMIN";
    public static final String USER_ROLE = "USER";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser(ADMIN_ROLE)
                .password("{noop}admin")
                .roles(ADMIN_ROLE, USER_ROLE)
                .and()
                .withUser("Client")
                .password("{noop}kkdmmc")
                .roles("USER")
                .and()
                .withUser("lenep")
                .password("{noop}password")
                .roles(ADMIN_ROLE, USER_ROLE)
                .and()
                .withUser("lene")
                .password("{noop}password")
                .roles(ADMIN_ROLE, USER_ROLE);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/bookingSystem/**/create", "/bookingSystem/**delete").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/bookingSystem/**/read", "/bookingSystem/**all").hasRole(USER_ROLE)
                .and()
                .csrf().disable()
                .formLogin().disable();


    }
}
