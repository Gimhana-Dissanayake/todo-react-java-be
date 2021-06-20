package com.example.repository;

import com.example.security.JwtUserDetails;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<JwtUserDetails, Long> {

}
