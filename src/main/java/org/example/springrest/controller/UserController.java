package org.example.springrest.controller;

import org.example.springrest.domain.User;
import org.example.springrest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService,  PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return  ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    // id as part of API
    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }

    // id as param
    // for ex. http://localhost:8090/userid/123
    @GetMapping("/userid/")
    public User findUserById2(@RequestParam Long id) {
        return this.userService.getUserById(id);
    }

    @GetMapping("/")
    public List<User> findAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/helloUser")
    public String helloUser() {
        return "helloUser";
    }

    @DeleteMapping("/user/")
    public String deleteUserById(@RequestParam Long id) {
        this.userService.deleteUserById(id);
        return "Deleted successfully";
    }
}
