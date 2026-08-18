package io.github.esherna7.vaultdex.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "tracked_sets")
public class TrackedSets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long id;

    @Column(name = "game_id")
    private long gameId;

    @Column(name = "set_id")
    private long setId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "tracked_at")
    private Instant trackedAt;

    public TrackedSets() {
    }

    public TrackedSets(long id, long gameId, long setId, long userId, Instant trackedAt) {
        this.id = id;
        this.gameId = gameId;
        this.setId = setId;
        this.userId = userId;
        this.trackedAt = trackedAt;
    }

    public long getId() {
        return id;
    }

    public long getGameId() {
        return gameId;
    }

    public long getSetId() {
        return setId;
    }

    public long getUserId() {
        return userId;
    }

    public Instant getTrackedAt() {
        return trackedAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public void setSetId(long setId) {
        this.setId = setId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setTrackedAt(Instant trackedAt) {
        this.trackedAt = trackedAt;
    }
}
