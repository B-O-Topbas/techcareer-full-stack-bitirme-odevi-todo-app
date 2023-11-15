package com.beytullahonur.todoapp.domain.todo.usecase;

import com.beytullahonur.todoapp.domain.todo.commands.UpdateTodoCommand;

public interface UpdateTodoUseCase {
    void updateTodo(UpdateTodoCommand updateTodoCommand);
}