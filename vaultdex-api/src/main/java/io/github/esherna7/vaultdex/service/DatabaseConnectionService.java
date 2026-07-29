package io.github.esherna7.vaultdex.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseConnectionService {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseConnectionService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, Object> checkConnection() {
        Map<String, Object> response = new HashMap<>();
        try {
            Integer ping = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            String database = jdbcTemplate.queryForObject("SELECT current_database()", String.class);

            response.put("connected", true);
            response.put("ping", ping);
            response.put("database", database);
            response.put("message", "Database connection successful");
        } catch (Exception exception) {
            response.put("connected", false);
            response.put("message", "Database connection failed");
            response.put("error", exception.getMessage());
        }

        return response;
    }
}
