package com.beytullahonur.todoapp.domain.user.commands;

import java.util.UUID;

public record GetUserCommand(UUID id,String name) {
}
