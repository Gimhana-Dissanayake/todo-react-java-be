package com.example.controller;

import com.example.domain.HelloBean;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthenticationController {
    @GetMapping(path = "/basicauth")
    public HelloBean helloWorldBean() {
        return new HelloBean("You are authenticated");
    }
}
