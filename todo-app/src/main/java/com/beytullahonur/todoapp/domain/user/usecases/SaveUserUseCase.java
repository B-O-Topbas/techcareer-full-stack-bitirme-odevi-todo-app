package com.beytullahonur.todoapp.domain.user.usecases;

import com.beytullahonur.todoapp.domain.user.commands.SaveUserCommand;

public interface SaveUserUseCase  {
    void saveUser(SaveUserCommand saveUserCommand);
}
