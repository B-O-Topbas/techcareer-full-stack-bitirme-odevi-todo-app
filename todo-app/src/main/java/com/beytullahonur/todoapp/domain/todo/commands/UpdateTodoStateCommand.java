package com.beytullahonur.todoapp.domain.todo.commands;

import java.util.UUID;

public record UpdateTodoStateCommand(UUID id, boolean doneState) {
}