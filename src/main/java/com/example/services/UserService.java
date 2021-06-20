package com.example.services;

import com.example.repository.UserRepository;
import com.example.security.JwtUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public JwtUserDetails save(JwtUserDetails jwtUserDetails) {

        return userRepository.save(jwtUserDetails);

    }

}
