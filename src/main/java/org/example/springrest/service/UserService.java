package org.example.springrest.service;

import org.example.springrest.domain.User;
import org.example.springrest.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        this.userRepository.save(user);
        return user;
    }

    public User updateUser(User user) {
        this.userRepository.save(user);
        return user;
    }

    public User getUserById(Long id) {
        return this.userRepository.findUserById(id);
    }

    public User getUserByEmail(String email) {
        return this.userRepository.findUserByEmail(email);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUserByName(String name) {
        return this.userRepository.findUserByName(name);
    }

    public User deleteUserById(Long id) {
        return this.userRepository.deleteUserById(id);
    }
}
