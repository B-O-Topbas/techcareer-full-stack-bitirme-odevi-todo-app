package com.beytullahonur.todoapp.domain.user;

import com.beytullahonur.todoapp.domain.user.commands.GetUserCommand;
import com.beytullahonur.todoapp.domain.user.commands.SaveUserCommand;
import com.beytullahonur.todoapp.domain.user.usecases.UserUseCase;
import com.beytullahonur.todoapp.infrastracture.user.Role;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements UserUseCase {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public GetUserCommand getUser(UUID id) {
        var user=userRepository.findUserById(id);
        return new GetUserCommand(user.getId(),user.getName());
    }

    @Override
    public GetUserCommand getUSerByUserName(String userName) {
        var user =userRepository.findUserByUserName(userName);
        return new GetUserCommand(user.getId(),user.getName());
    }

    @Override
    public void saveUser(SaveUserCommand saveUserCommand) {
        var user=new User(saveUserCommand.name(), saveUserCommand.userName(), saveUserCommand.password(),Role.USER);
        userRepository.saveUser(user);
    }
}