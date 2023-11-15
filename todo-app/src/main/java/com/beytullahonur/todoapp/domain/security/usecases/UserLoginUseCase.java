package com.beytullahonur.todoapp.domain.security.usecases;

import com.beytullahonur.todoapp.domain.security.commands.JwtCommand;
import com.beytullahonur.todoapp.domain.security.commands.LoginCommand;

public interface UserLoginUseCase {
    JwtCommand login(LoginCommand loginCommand);

}
