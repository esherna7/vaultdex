package io.github.esherna7.vaultdex.controller;

import org.springframework.http.ResponseEntity;
import io.github.esherna7.vaultdex.dto.CreateUserRequest;
import io.github.esherna7.vaultdex.dto.LoginRequest;
import io.github.esherna7.vaultdex.dto.UserResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import io.github.esherna7.vaultdex.service.UserService;
import io.github.esherna7.vaultdex.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final SecurityContextRepository securityContextRepository;

    @Autowired
    public UserController(UserService userService, SecurityContextRepository securityContextRepository) {
        this.userService = userService;
        this.securityContextRepository = securityContextRepository;
    }

    public UserController(UserService userService) {
        this(userService, new org.springframework.security.web.context.HttpSessionSecurityContextRepository());
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        User user = userService.createUser(request.email(), request.username(), request.password());
        return ResponseEntity.ok(UserResponse.from(user));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@Valid @RequestBody LoginRequest request,
            HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        User user = userService.loginUser(request.username(), request.password());
        if (user == null) {
            return ResponseEntity.status(401).build();
        }

        Authentication authentication = UsernamePasswordAuthenticationToken.authenticated(
                user, null, java.util.Collections.emptyList());
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
        if (httpRequest != null && httpResponse != null) {
            securityContextRepository.saveContext(context, httpRequest, httpResponse);
        }

        return ResponseEntity.ok(UserResponse.from(user));
    }

    public ResponseEntity<UserResponse> loginUser(LoginRequest request) {
        return loginUser(request, null, null);
    }

    @GetMapping("/me")
    public UserResponse currentUser(Authentication authentication) {
        return UserResponse.from((User) authentication.getPrincipal());
    }
}
