package com.beytullahonur.todoapp.infrastracture.todo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TodoJpaRepository extends JpaRepository<TodoJpaEntity, UUID> {
    List<TodoJpaEntity> findByUserJpaEntityId(final UUID id);
}