package com.beytullahonur.todoapp.domain.todo.commands;
import java.util.UUID;

public record UpdateTodoCommand(UUID id,String todo) {
}