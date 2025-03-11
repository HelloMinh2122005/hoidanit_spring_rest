package org.example.springrest.controller;

import org.example.springrest.domain.User;
import org.example.springrest.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String createUser() {
        User user = new User();
        user.setName("admin 1");
        user.setEmail("admin1@admin.com");
        return userService.createUser(user);
    }
}
