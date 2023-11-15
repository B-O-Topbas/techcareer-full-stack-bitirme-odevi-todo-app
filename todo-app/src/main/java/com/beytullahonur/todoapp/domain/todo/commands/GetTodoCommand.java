package com.beytullahonur.todoapp.domain.todo.commands;

import java.util.Date;
import java.util.UUID;

public record GetTodoCommand(UUID id, String todo, boolean doneState
        , Date creationDate,UUID userId){
}