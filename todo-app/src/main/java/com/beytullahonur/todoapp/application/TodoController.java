package com.beytullahonur.todoapp.application;

import com.beytullahonur.todoapp.domain.todo.commands.GetTodoCommand;
import com.beytullahonur.todoapp.domain.todo.commands.SaveTodoCommand;
import com.beytullahonur.todoapp.domain.todo.commands.UpdateTodoCommand;
import com.beytullahonur.todoapp.domain.todo.commands.UpdateTodoStateCommand;
import com.beytullahonur.todoapp.domain.todo.usecase.TodoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoUseCase todoUseCase;

    public TodoController(TodoUseCase todoUseCase) {
        this.todoUseCase = todoUseCase;
    }

    @GetMapping
    public ResponseEntity<List<GetTodoCommand>> getAllTodos(){
        return new ResponseEntity<>(todoUseCase.getAllTodos(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetTodoCommand> getTodo(@PathVariable UUID id){
        return new ResponseEntity<>(todoUseCase.getTodo(id), HttpStatus.OK);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<GetTodoCommand>> getUsersTodos(@PathVariable UUID userId){
        return new ResponseEntity<>(todoUseCase.getUsersTodos(userId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addTodo(@RequestBody SaveTodoCommand todoCommand){
        todoUseCase.saveTodo(todoCommand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable UUID id){
        todoUseCase.deleteTodo(id);
    }
    @DeleteMapping
    public void  deleteAllTodos(){
        todoUseCase.deleteAllTodo();
    }

    @PutMapping
    public void updateTodo(@RequestBody UpdateTodoCommand updateTodoCommand){
        todoUseCase.updateTodo(updateTodoCommand);
    }
    @PutMapping("/state")
    public void updateTodoState(@RequestBody UpdateTodoStateCommand updateTodoStateCommand){
        todoUseCase.updateTodoState(updateTodoStateCommand);
    }
}