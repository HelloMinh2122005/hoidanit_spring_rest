package org.example.springrest.service;

import org.example.springrest.domain.User;
import org.example.springrest.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createUser(User user) {
        userRepository.save(user);
        return "User created successfully";
    }
}
