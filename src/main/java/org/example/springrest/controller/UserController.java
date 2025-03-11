package org.example.springrest.controller;

import org.example.springrest.domain.User;
import org.example.springrest.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return this.userService.createUser(user);
    }

    @PostMapping("/user/update")
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
}
