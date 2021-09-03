package com.bookwarm.library.controllers;

import com.bookwarm.library.persistence.model.User;
import com.bookwarm.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(params = { "email", "password" })
    public User findByEmail(@RequestParam("email") String email,
                            @RequestParam("password") String password) {
        return userService.findByEmail(email, password);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
}
