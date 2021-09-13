package com.bookwarm.library.controllers;

import com.bookwarm.library.exceptions.UserAlreadyExistsException;
import com.bookwarm.library.payload.LoginRequest;
import com.bookwarm.library.payload.LoginResponse;
import com.bookwarm.library.payload.MessageResponse;
import com.bookwarm.library.payload.RegistrationRequest;
import com.bookwarm.library.persistence.model.User;
import com.bookwarm.library.security.JwtTokenService;
import com.bookwarm.library.services.RoleService;
import com.bookwarm.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        User user = userService.findByEmail(loginRequest.getEmail());
        if (user == null) {
            return ResponseEntity
                    .status(401)
                    .body(new MessageResponse("Пользователя с таким адресом электронной почты не существует."));
        }
        if (userService.verifyPassword(user, loginRequest.getPassword())) {
            String token = jwtTokenService.buildToken(user);
            return ResponseEntity
                    .status(200)
                    .body(new LoginResponse(token));
        } else {
            return ResponseEntity
                    .status(401)
                    .body(new MessageResponse("Неверный пароль."));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        User user = new User();
        user.setEmail(registrationRequest.getEmail());
        user.setUsername(registrationRequest.getUsername());
        user.setPassword(registrationRequest.getPassword());
        user.setRole(roleService.findByName("ROLE_USER"));

        try {
            userService.create(user);
            return ResponseEntity
                    .ok(new MessageResponse("Регистрация прошла успешно!"));
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(e.getMessage()));
        }
    }
}
