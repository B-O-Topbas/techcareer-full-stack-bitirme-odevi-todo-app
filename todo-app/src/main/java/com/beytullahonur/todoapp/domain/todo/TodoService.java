package com.beytullahonur.todoapp.domain.todo;

import com.beytullahonur.todoapp.domain.todo.commands.GetTodoCommand;
import com.beytullahonur.todoapp.domain.todo.commands.SaveTodoCommand;
import com.beytullahonur.todoapp.domain.todo.commands.UpdateTodoCommand;
import com.beytullahonur.todoapp.domain.todo.commands.UpdateTodoStateCommand;
import com.beytullahonur.todoapp.domain.todo.usecase.TodoUseCase;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TodoService implements TodoUseCase {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void deleteTodo(final UUID id) {
        todoRepository.deleteTodo(id);
    }

    @Override
    public GetTodoCommand getTodo(final UUID id) {
        var todo=todoRepository.findTodo(id);
        return new GetTodoCommand(todo.getId(),todo.getTodos(),todo.isDoneState(),todo.getCreationDate(),todo.getUserId());
    }

    @Override
    public List<GetTodoCommand> getAllTodos() {
        var todoList=todoRepository.getAll();
       return todoList.stream()
                .map(todo -> new GetTodoCommand(todo.getId(),todo.getTodos(),todo.isDoneState(),todo.getCreationDate(),todo.getUserId()))
               .toList();

    }

    @Override
    public List<GetTodoCommand> getUsersTodos(final UUID userId) {
        var usersTodo=todoRepository.getUsersTodo(userId);
        return usersTodo.stream()
                .map(todo -> new GetTodoCommand(todo.getId(),todo.getTodos(),todo.isDoneState(),todo.getCreationDate(),todo.getUserId()))
                .toList();
    }



    @Override
    public void updateTodoState(final UpdateTodoStateCommand updateTodoStateCommand) {
        var todo=todoRepository.findTodo(updateTodoStateCommand.id());
        todo.setDoneState(updateTodoStateCommand.doneState());
        todoRepository.saveTodo(todo);
    }

    @Override
    public void updateTodo(final UpdateTodoCommand updateTodoCommand) {
        var todo=todoRepository.findTodo(updateTodoCommand.id());
        try {
            todo.updateTodo(updateTodoCommand.todo());
            todoRepository.saveTodo(todo);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void saveTodo(SaveTodoCommand saveTodoCommand) {
        var todo=new Todo();
        todo.setTodos(saveTodoCommand.todo());
        todo.setCreationDate(new Date());
        todo.setDoneState(false);
        todo.setUserId(saveTodoCommand.userId());
        todoRepository.saveTodo(todo);
    }

    @Override
    public void deleteAllTodo() {
        todoRepository.deleteAllTodos();
    }
}