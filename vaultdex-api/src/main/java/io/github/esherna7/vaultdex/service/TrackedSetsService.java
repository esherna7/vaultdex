package io.github.esherna7.vaultdex.service;

import java.util.List;
import java.util.Optional;
import java.time.Instant;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import io.github.esherna7.vaultdex.dto.TrackedSetsResponse;
import io.github.esherna7.vaultdex.entity.Sets;
import io.github.esherna7.vaultdex.entity.TrackedSets;
import io.github.esherna7.vaultdex.repository.SetsRepository;
import io.github.esherna7.vaultdex.repository.TrackedSetsRepository;

@Service
public class TrackedSetsService {

    private final TrackedSetsRepository trackedSetsRepository;
    private final SetsRepository setsRepository;

    public TrackedSetsService(TrackedSetsRepository trackedSetsRepository, SetsRepository setsRepository) {
        this.trackedSetsRepository = trackedSetsRepository;
        this.setsRepository = setsRepository;
    }

    public Optional<TrackedSets> findBySetIdAndUserId(long setId, long userId) {
        return trackedSetsRepository.findByUserIdAndSetId(userId, setId);
    }

    public List<TrackedSetsResponse> getTrackedSets(long userId) {
        return trackedSetsRepository.findByUserId(userId).stream()
            .map(trackedSet -> TrackedSetsResponse.from(
                trackedSet,
                setsRepository.findById(trackedSet.getSetId()).orElseThrow()))
                .toList();
    }

    public void trackSet(long userId, String setCode) {
        Sets set = setsRepository.findByCode(setCode)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Unknown set code: " + setCode));

        if (trackedSetsRepository.findByUserIdAndSetId(userId, set.getId()).isPresent()) {
            return;
        }

        trackedSetsRepository.save(new TrackedSets(
            0,
                set.getGameId(),
                set.getId(),
                userId,
                Instant.now()));
    }

}
