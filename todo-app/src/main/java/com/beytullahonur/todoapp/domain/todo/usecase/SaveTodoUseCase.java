package com.beytullahonur.todoapp.domain.todo.usecase;

import com.beytullahonur.todoapp.domain.todo.commands.SaveTodoCommand;

public interface SaveTodoUseCase {
    void saveTodo(SaveTodoCommand saveTodoCommand);
}
