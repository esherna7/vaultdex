package io.github.esherna7.vaultdex.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.esherna7.vaultdex.service.DatabaseConnectionService;

@RestController
@RequestMapping("/api/test")
public class DatabaseTestController {

    private final DatabaseConnectionService databaseConnectionService;

    public DatabaseTestController(DatabaseConnectionService databaseConnectionService) {
        this.databaseConnectionService = databaseConnectionService;
    }

    @GetMapping("/db")
    public ResponseEntity<Map<String, Object>> testDatabaseConnection() {
        Map<String, Object> result = databaseConnectionService.checkConnection();
        boolean connected = Boolean.TRUE.equals(result.get("connected"));

        if (connected) {
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(result);
    }
}
