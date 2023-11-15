package com.beytullahonur.todoapp.infrastracture.todo.jpa;

import com.beytullahonur.todoapp.domain.todo.Todo;
import com.beytullahonur.todoapp.domain.todo.TodoRepository;
import com.beytullahonur.todoapp.infrastracture.todo.TodoMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TodoPersistence implements TodoRepository {
    private final TodoJpaRepository todoJpaRepository;
    private final TodoMapper todoMapper;

    public TodoPersistence(TodoJpaRepository todoJpaRepository, TodoMapper todoMapper) {
        this.todoJpaRepository = todoJpaRepository;
        this.todoMapper = todoMapper;
    }

    @Transactional
    @Override
    public void saveTodo(Todo todo) {
        var todoJpaEntity=todoMapper.mapToJpaEntity(todo);
      todoJpaRepository.save(todoJpaEntity);
    }

    @Override
    public void deleteTodo(UUID id) {
        todoJpaRepository.deleteById(id);
    }

    @Override
    public List<Todo> getAll() {
        var todoJpaEntities=todoJpaRepository.findAll();
        return todoJpaEntities.stream()
                .map(todoMapper::mapToDomainEntity)
                .toList();
    }

    @Override
    public List<Todo> getUsersTodo(UUID userId) {
        var todoJpaEntities=todoJpaRepository.findByUserJpaEntityId(userId);
        return todoJpaEntities.stream()
                .map(todoMapper::mapToDomainEntity)
                .toList();
    }
    @Override
    public Todo findTodo(UUID id) {
        var todoJpaEntity=todoJpaRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        return todoMapper.mapToDomainEntity(todoJpaEntity);
    }
    @Override
    public void deleteAllTodos(){
        todoJpaRepository.deleteAll();
    }
}