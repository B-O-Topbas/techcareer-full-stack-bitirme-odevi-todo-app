package com.beytullahonur.todoapp.infrastracture.configuration;

public interface EntityMapper<T, E> {
    T mapToDomainEntity(final E e);

    E mapToJpaEntity(final T t);
}