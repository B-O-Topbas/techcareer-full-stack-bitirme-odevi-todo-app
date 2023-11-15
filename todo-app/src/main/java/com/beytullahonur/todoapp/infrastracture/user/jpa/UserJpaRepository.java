package com.beytullahonur.todoapp.infrastracture.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, UUID> {
    Optional<UserJpaEntity> findByUserName(String userName);
    Boolean existsByUserName(String userName);
}