package com.beytullahonur.todoapp.domain.todo.usecase;

import java.util.UUID;

public interface DeleteTodoUseCase  {
    void deleteTodo(UUID id);
}