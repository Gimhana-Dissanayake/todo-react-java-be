package com.example.controller;

import com.example.domain.HelloBean;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping(path = "/hello-bean")
    public HelloBean helloBean() {
        return new HelloBean("Hello from bean");
    }

    @GetMapping(path = "/hello-bean/path-variable/{name}")
    public HelloBean helloBeanPathVariable(@PathVariable String name) {
        return new HelloBean(String.format("Hello, %s", name));
    }

    @GetMapping(path = "/hello-error")
    public HelloBean helloError() {
        throw new RuntimeException("Something went wrong");
    }
}
