package io.github.esherna7.vaultdex.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sets")
public class Sets {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long id;

    @Column(name = "game_id")
    private long gameId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "release_date")
    private Instant releaseDate;

    public Sets() {

    }

    public Sets(long id, long gameId, String code, String name, Instant releaseDate) {
        this.id = id;
        this.gameId = gameId;
        this.code = code;
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public long getId() {
        return id;
    }

    public long getGameId() {
        return gameId;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Instant getReleaseDate() {
        return releaseDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseDate(Instant releaseDate) {
        this.releaseDate = releaseDate;
    }
}
