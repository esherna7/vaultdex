package io.github.esherna7.vaultdex.service;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    private final JdbcTemplate jdbcTemplate;

    public CardService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> getAllCards() {
        return jdbcTemplate.queryForList("SELECT id, name, obtained_date FROM cards ORDER BY id");
    }
}
