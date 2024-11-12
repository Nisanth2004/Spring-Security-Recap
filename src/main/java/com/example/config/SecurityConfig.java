package com.example.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
       http.formLogin(withDefaults());
       http.httpBasic(withDefaults());

        // disable the session-id
        http.sessionManagement(session->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }


    // In memory Authentication

    @Bean
    public UserDetailsService userDetailsService()
    {

        UserDetails user1= User
                .withUsername("user1")
                .password("{noop}password1")
                .roles("USER")
                .build();

        UserDetails admin= User.withUsername("admin").password("{noop}adminPass").roles("ADMIN").build();
        /*
           calling the constrcutor , you can view this in InMemoryUserDetailsManager
           This contructor accepts the UserDetails Object so we can pass the inmemory user to this constrctor
         */
        return new InMemoryUserDetailsManager(user1,admin);
    }
}
