package io.github.esherna7.vaultdex.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.github.esherna7.vaultdex.dto.LoginRequest;
import io.github.esherna7.vaultdex.dto.UserResponse;
import io.github.esherna7.vaultdex.entity.User;
import io.github.esherna7.vaultdex.service.UserService;

class UserControllerTest {

    @Test
    void loginUserReturnsUserResponseForValidCredentials() {
        User user = new User(1L, "test@example.com", "tester", "hashed", Instant.now());
        UserService stubService = new UserService(null, null) {
            @Override
            public User loginUser(String username, String password) {
                return user;
            }
        };

        UserController controller = new UserController(stubService);
        ResponseEntity<UserResponse> response = controller.loginUser(new LoginRequest("tester", "Password123!"));

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("tester", response.getBody().username());
    }
}
