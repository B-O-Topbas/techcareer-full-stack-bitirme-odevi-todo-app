package com.beytullahonur.todoapp.domain.todo.usecase;
import com.beytullahonur.todoapp.domain.todo.commands.UpdateTodoStateCommand;

public interface UpdateTodoStateUseCase  {
    void updateTodoState(UpdateTodoStateCommand updateTodoStateCommand);
}