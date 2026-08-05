package io.github.esherna7.vaultdex.service;

import java.time.Instant;

import org.springframework.stereotype.Service;
import io.github.esherna7.vaultdex.exception.DuplicateEmailException;
import io.github.esherna7.vaultdex.exception.DuplicateUsernameException;
import io.github.esherna7.vaultdex.entity.User;

import io.github.esherna7.vaultdex.repository.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(String email, String username, String password) {
        if (usersRepository.existsByUsername(username)) {
            throw new DuplicateUsernameException(username);
        }

        if (usersRepository.existsByEmail(email)) {
            throw new DuplicateEmailException(email);
        }

        String hashed = passwordEncoder.encode(password);
        User user = new User(0, email, username, hashed, Instant.now());
        return usersRepository.save(user);
    }

    public User findByUsername(String username) {
        return usersRepository.findByUsername(username).orElse(null);
    }

    public User loginUser(String username, String password) {
        User user = usersRepository.findByUsername(username).orElse(null);
        if (user == null) {
            return null;
        }

        if (!passwordEncoder.matches(password, user.getPasswordHash())) {
            return null;
        }

        return user;
    }

}
