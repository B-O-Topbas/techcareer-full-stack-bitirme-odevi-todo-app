package com.beytullahonur.todoapp.application;

import com.beytullahonur.todoapp.domain.security.commands.JwtCommand;
import com.beytullahonur.todoapp.domain.security.commands.LoginCommand;
import com.beytullahonur.todoapp.domain.security.usecases.AuthenticationUseCase;
import com.beytullahonur.todoapp.domain.user.commands.SaveUserCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/security")
public class SecurityController {
    private final AuthenticationUseCase authenticationUseCase;

    public SecurityController(AuthenticationUseCase authenticationUseCase) {
        this.authenticationUseCase = authenticationUseCase;
    }
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody SaveUserCommand saveUserCommand){
        authenticationUseCase.register(saveUserCommand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<JwtCommand> login(@RequestBody LoginCommand loginCommand){

        return new ResponseEntity<>(authenticationUseCase.login(loginCommand),HttpStatus.OK);
    }
}