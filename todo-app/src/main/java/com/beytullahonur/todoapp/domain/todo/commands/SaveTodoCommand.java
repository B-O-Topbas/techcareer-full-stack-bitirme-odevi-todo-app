package com.beytullahonur.todoapp.domain.todo.commands;

import java.util.UUID;

public record SaveTodoCommand(String todo, UUID userId)  {
}