package io.github.esherna7.vaultdex.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank @Email String email,
        @NotBlank @Size(min = 3, max = 32) String username,
        @NotBlank @Size(min = 8, message = "Password must be at least 8 characters") String password) {
}