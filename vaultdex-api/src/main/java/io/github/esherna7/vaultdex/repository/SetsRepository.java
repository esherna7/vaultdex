package io.github.esherna7.vaultdex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.esherna7.vaultdex.entity.Sets;

@Repository
public interface SetsRepository extends JpaRepository<Sets, Long> {

    Optional<Sets> findByCode(String code);
}
