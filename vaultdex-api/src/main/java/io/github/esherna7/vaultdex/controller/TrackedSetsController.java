package io.github.esherna7.vaultdex.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.esherna7.vaultdex.dto.TrackedSetsResponse;
import io.github.esherna7.vaultdex.entity.User;
import io.github.esherna7.vaultdex.service.TrackedSetsService;

@RestController
@RequestMapping("/api/trackedSets")
public class TrackedSetsController {

    private final TrackedSetsService trackedSetsService;

    public TrackedSetsController(TrackedSetsService trackedSetsService) {
        this.trackedSetsService = trackedSetsService;
    }

    @GetMapping
    public List<TrackedSetsResponse> getTrackedSets(@AuthenticationPrincipal User currentUser) {
        return trackedSetsService.getTrackedSets(currentUser.getId());
    }

}
