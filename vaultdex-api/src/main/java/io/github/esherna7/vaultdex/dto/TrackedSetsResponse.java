package io.github.esherna7.vaultdex.dto;

import java.time.Instant;

import io.github.esherna7.vaultdex.entity.TrackedSets;

public record TrackedSetsResponse(
        Long id,
        long gameId,
        long setId,
        long userId,
        Instant trackedAt) {

    public static TrackedSetsResponse from(TrackedSets trackedSet) {
        return new TrackedSetsResponse(
                trackedSet.getId(),
                trackedSet.getGameId(),
                trackedSet.getSetId(),
                trackedSet.getUserId(),
                trackedSet.getTrackedAt());
    }

}
