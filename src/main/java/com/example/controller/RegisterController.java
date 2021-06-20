
package com.example.controller;

import com.example.security.JwtUserDetails;
import com.example.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RegisterController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(path = "/register")
    public JwtUserDetails register(@RequestBody JwtUserDetails requestBody) {

        requestBody.setPassword(passwordEncoder.encode(requestBody.getPassword()));

        return userService.save(requestBody);

    }
}
