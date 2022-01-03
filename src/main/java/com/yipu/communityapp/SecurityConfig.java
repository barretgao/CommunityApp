package com.yipu.communityapp;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    //this method is for authorization part.
    protected void configure(HttpSecurity http) throws Exception {
        http
                //csrf cross site request forgery.
                .csrf().disable()
                //support form based authorization.
                //form element in the http request.
                .formLogin()
                //if there is a failure, we forward the add the url.
                //need a controller to handler this part of url.
                //error is the key, true is the value.
                .failureForwardUrl("/login?error=true");
        http
                //authorize the request.
                .authorizeRequests()
                //when user request this following patterns, we need authorization.
                //hasAuthority will check if the user has the authroized role.
                .antMatchers("/dashboard/*", "/chat").hasAuthority("ROLE_USER")
                //the rest of request does not need authorization.
                .anyRequest().permitAll();
    }

    @Override
    //override this method to modify the authentication part.
    //security filter can automatically grab the username and password.
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                //? is a placeholder that store user passed in information.
                .usersByUsernameQuery("SELECT email, password, enabled FROM customer WHERE email=?")
                .authoritiesByUsernameQuery("SELECT email, authorities FROM authorities WHERE email=?");

    }

    @SuppressWarnings("deprecation")
    @Bean
    //this will not encode the password send from the url.
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}