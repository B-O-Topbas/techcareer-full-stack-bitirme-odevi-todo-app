package com.beytullahonur.todoapp.domain.user.usecases;

import com.beytullahonur.todoapp.domain.user.commands.GetUserCommand;

import java.util.UUID;
public interface GetUserUseCase {
    GetUserCommand getUser(UUID id);
    GetUserCommand getUSerByUserName(String userName);
}