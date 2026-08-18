package io.github.esherna7.vaultdex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.github.esherna7.vaultdex.dto.TrackedSetsResponse;
import io.github.esherna7.vaultdex.entity.TrackedSets;
import io.github.esherna7.vaultdex.repository.TrackedSetsRepository;

@Service
public class TrackedSetsService {

    private final TrackedSetsRepository trackedSetsRepository;

    public TrackedSetsService(TrackedSetsRepository trackedSetsRepository) {
        this.trackedSetsRepository = trackedSetsRepository;
    }

    public Optional<TrackedSets> findBySetIdAndUserId(long setId, long userId) {
        return trackedSetsRepository.findByUserIdAndSetId(userId, setId);
    }

    public List<TrackedSetsResponse> getTrackedSets(long userId) {
        return trackedSetsRepository.findByUserId(userId).stream()
                .map(TrackedSetsResponse::from)
                .toList();
    }

}
