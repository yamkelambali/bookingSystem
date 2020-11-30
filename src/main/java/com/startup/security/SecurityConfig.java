//package com.startup.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
////@ Configuration tells spring that this is a configuration class
////@ EnableWebSecurity makes sure that spring uses class for web security
//@Configuration
//@EnableWebSecurity
//
////This class is responsible for configuring all security configurations in an application
////This class contains default implementations of users and passwords
////Here we are telling spring the type of users and passwords we want
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    public static final String ADMIN_ROLE = "ADMIN";
//    public static final String USER_ROLE = "USER";
//
//    //configures credentials (AuthenticationManagerBuilder auth)
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        // inMemoryAuthentication() in memory implementations that is in the memory of the application and not tied to any data store
//        // application type is in memory which stores the username, password and roles
//        // withUser() username
//        // password() password
//        // roles() ability to attach roles
//        // and() is used for adding more than one user
//
//        auth.inMemoryAuthentication()
//                .withUser("Admin")
//                .password(encoder().encode("admin123"))
//                .roles(ADMIN_ROLE, USER_ROLE)
//                .and()
//                .withUser("Client")
//                .password(encoder().encode("client123"))
//                .roles(USER_ROLE);
//
//    }
//
//    //configures http security (HttpSecurity http)
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // used for defining particular end points for each role and who access to those endpoints
//        // http() kind of http we are using
//        // authorizeRequests() authorizes all requests
//        // antMatchers() specifies request particular user can use and the request(s) the user has access to
//
//        http.httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/bookingSystem/**/create", "/bookingSystem/**/generate", "/bookingSystem/**/delete/**").hasRole(ADMIN_ROLE)
//                .antMatchers(HttpMethod.GET, "/bookingSystem/**/read", "/bookingSystem/**/all").hasRole(USER_ROLE)
//                .and()
//                .csrf().disable();
//
//    }
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
