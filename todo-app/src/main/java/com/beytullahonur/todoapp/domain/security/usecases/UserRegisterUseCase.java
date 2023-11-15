package com.beytullahonur.todoapp.domain.security.usecases;

import com.beytullahonur.todoapp.domain.user.commands.SaveUserCommand;

public interface UserRegisterUseCase {
    void register(SaveUserCommand saveUserCommand);
}
