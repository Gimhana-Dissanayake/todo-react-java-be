package com.example.security;

import java.util.Optional;

import com.example.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  // static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  // static {
  //   inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
  //       "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
  //   inMemoryUserList.add(
  //       new JwtUserDetails(2L, "malan", "$2a$10$d4xuX7l0Mq3TJDtUnZNnoeO.udTEau3c23ZnfGMSk8dkV20T84ag.", "ROLE_USER_2"));
  // }

  @Autowired
  UserRepository userRepository;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = userRepository.findAll().stream().filter(user -> user.getUsername().equals(username))
        .findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}
