package com.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

@RestController
public class GreetController {

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }



    @PreAuthorize("hasRole('USER')")// check authorizatiob of user
    @GetMapping("/user")
    public String user()
    {
        return "hello User";
    }

    @PreAuthorize("hasRole('ADMIN')")// check authorizatiob of user
    @GetMapping("/admin")
    public String admin()
    {
        return "hello Admin";
    }

}
