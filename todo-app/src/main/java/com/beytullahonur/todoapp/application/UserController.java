package com.beytullahonur.todoapp.application;

import com.beytullahonur.todoapp.domain.user.commands.GetUserCommand;
import com.beytullahonur.todoapp.domain.user.commands.SaveUserCommand;
import com.beytullahonur.todoapp.domain.user.usecases.UserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserUseCase useCase;

    public UserController(UserUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody SaveUserCommand userCommand){
        useCase.saveUser(userCommand);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("{userName}")
    public ResponseEntity<GetUserCommand> getUserByUserName(@PathVariable String userName){
        return new ResponseEntity<>(useCase.getUSerByUserName(userName),HttpStatus.OK);
    }
}