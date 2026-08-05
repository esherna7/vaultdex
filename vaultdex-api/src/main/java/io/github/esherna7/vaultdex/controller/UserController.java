package io.github.esherna7.vaultdex.controller;

import org.springframework.http.ResponseEntity;
import io.github.esherna7.vaultdex.dto.CreateUserRequest;
import io.github.esherna7.vaultdex.dto.LoginRequest;
import io.github.esherna7.vaultdex.dto.UserResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.github.esherna7.vaultdex.service.UserService;
import io.github.esherna7.vaultdex.entity.User;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        User user = userService.createUser(request.email(), request.username(), request.password());
        return ResponseEntity.ok(UserResponse.from(user));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@Valid @RequestBody LoginRequest request) {
        User user = userService.loginUser(request.username(), request.password());
        if (user == null) {
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok(UserResponse.from(user));
    }
}
