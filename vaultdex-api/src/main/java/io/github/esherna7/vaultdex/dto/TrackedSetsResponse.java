package io.github.esherna7.vaultdex.dto;

import java.time.Instant;

import io.github.esherna7.vaultdex.entity.TrackedSets;
import io.github.esherna7.vaultdex.entity.Sets;

public record TrackedSetsResponse(
        Long id,
        long gameId,
        long setId,
        String setCode,
        long userId,
        Instant trackedAt) {

    public static TrackedSetsResponse from(TrackedSets trackedSet) {
        return from(trackedSet, null);
    }

    public static TrackedSetsResponse from(TrackedSets trackedSet, Sets set) {
        return new TrackedSetsResponse(
                trackedSet.getId(),
                trackedSet.getGameId(),
                trackedSet.getSetId(),
                set == null ? null : set.getCode(),
                trackedSet.getUserId(),
                trackedSet.getTrackedAt());
    }

}
