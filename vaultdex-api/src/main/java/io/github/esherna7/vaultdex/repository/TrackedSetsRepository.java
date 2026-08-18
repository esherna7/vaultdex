package io.github.esherna7.vaultdex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.esherna7.vaultdex.entity.TrackedSets;

@Repository
public interface TrackedSetsRepository extends JpaRepository<TrackedSets, Long> {

    Optional<TrackedSets> findByUserIdAndSetId(long userId, long setId);

    List<TrackedSets> findByUserId(long userId);

}