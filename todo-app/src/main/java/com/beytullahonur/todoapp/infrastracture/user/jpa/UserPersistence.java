package com.beytullahonur.todoapp.infrastracture.user.jpa;

import com.beytullahonur.todoapp.domain.user.User;
import com.beytullahonur.todoapp.domain.user.UserRepository;
import com.beytullahonur.todoapp.infrastracture.user.UserMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserPersistence implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    public UserPersistence(UserJpaRepository userJpaRepository,  UserMapper userMapper) {
        this.userJpaRepository = userJpaRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void saveUser(User user) {
        var jpaUserEntity=userMapper.mapToJpaEntity(user);
        userJpaRepository.save(jpaUserEntity);
    }

    @Override
    public User findUserById(UUID id) {
        var userJpaEntity=userJpaRepository.findById(id).orElseThrow();
        return userMapper.mapToDomainEntity(userJpaEntity);
    }

    @Override
    public boolean checkUserIsExist(String userName) {
        return userJpaRepository.existsByUserName(userName);
    }

    @Override
    public User findUserByUserName(String userName) {
        var userJpaEntity=userJpaRepository.findByUserName(userName).orElseThrow();
        return userMapper.mapToDomainEntity(userJpaEntity);
    }
}
