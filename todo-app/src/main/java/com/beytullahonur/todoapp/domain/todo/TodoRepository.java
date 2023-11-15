package com.beytullahonur.todoapp.domain.todo;

import java.util.List;
import java.util.UUID;

public interface TodoRepository {
    void saveTodo(Todo todo);
    void deleteTodo(UUID id);
    List<Todo> getAll();
    List<Todo> getUsersTodo(UUID userId);
    Todo findTodo(UUID id);
    void deleteAllTodos();

}