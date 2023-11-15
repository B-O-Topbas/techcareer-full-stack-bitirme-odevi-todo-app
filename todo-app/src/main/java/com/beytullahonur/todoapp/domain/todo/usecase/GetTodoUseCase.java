package com.beytullahonur.todoapp.domain.todo.usecase;

import com.beytullahonur.todoapp.domain.todo.commands.GetTodoCommand;

import java.util.List;
import java.util.UUID;

public interface GetTodoUseCase  {
    GetTodoCommand getTodo(UUID id);
    List<GetTodoCommand> getAllTodos();
    List<GetTodoCommand> getUsersTodos(UUID userId);
}