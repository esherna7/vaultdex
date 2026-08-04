package io.github.esherna7.vaultdex.exception;

public class DuplicateUsernameException extends RuntimeException {
    public DuplicateUsernameException(String username) {
        super("An account with username " + username + " already exists.");
    }

}
