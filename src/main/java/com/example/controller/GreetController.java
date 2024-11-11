package com.example.controller;

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

}
