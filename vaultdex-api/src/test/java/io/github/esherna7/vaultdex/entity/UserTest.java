package io.github.esherna7.vaultdex.entity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void prePersistSetsCreatedAt() {
        User user = new User();

        user.prePersist();

        assertNotNull(user.getCreatedAt());
    }
}
