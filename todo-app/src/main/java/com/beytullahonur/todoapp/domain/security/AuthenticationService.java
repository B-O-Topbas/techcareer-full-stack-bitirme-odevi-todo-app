package com.beytullahonur.todoapp.domain.security;

import com.beytullahonur.todoapp.domain.security.commands.JwtCommand;
import com.beytullahonur.todoapp.domain.security.commands.LoginCommand;
import com.beytullahonur.todoapp.domain.security.usecases.AuthenticationUseCase;
import com.beytullahonur.todoapp.domain.user.User;
import com.beytullahonur.todoapp.domain.user.UserRepository;
import com.beytullahonur.todoapp.domain.user.commands.SaveUserCommand;
import com.beytullahonur.todoapp.infrastracture.user.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements AuthenticationUseCase {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public AuthenticationService(PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @Override
    public JwtCommand login(LoginCommand loginCommand) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginCommand.userName(),loginCommand.password()));
        var user=userRepository.findUserByUserName(loginCommand.userName());
        var token=jwtService.generateToken(user);
        return new JwtCommand(token);
    }

    @Override
    public void register(SaveUserCommand saveUserCommand) {
        if (Boolean.TRUE.equals(userRepository.checkUserIsExist(saveUserCommand.userName()))){
            throw new RuntimeException("Bu kullanıcı adı zaten kayıtlı");
        }else {
            var user=new User();
            user.setUserName(saveUserCommand.userName());
            user.setName(saveUserCommand.name());
            user.setPassword(passwordEncoder.encode(saveUserCommand.password()));
            user.setRole(Role.USER);
            userRepository.saveUser(user);
        }
    }
}