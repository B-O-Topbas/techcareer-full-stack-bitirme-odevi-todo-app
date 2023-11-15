package com.beytullahonur.todoapp.infrastracture.user;

import com.beytullahonur.todoapp.domain.user.User;
import com.beytullahonur.todoapp.infrastracture.configuration.EntityMapper;
import com.beytullahonur.todoapp.infrastracture.user.jpa.UserJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements EntityMapper<User, UserJpaEntity> {

    @Override
    public User mapToDomainEntity(UserJpaEntity userJpaEntity) {
        var user=new User();
        user.setId(userJpaEntity.getId());
        user.setName(userJpaEntity.getName());
        user.setUserName(userJpaEntity.getUsername());
        user.setPassword(userJpaEntity.getPassword());
        user.setRole(userJpaEntity.getRole());
        return user;
    }

    @Override
    public UserJpaEntity mapToJpaEntity(User user) {
        var userJpaEntity=new UserJpaEntity();
        userJpaEntity.setId(user.getId());
        userJpaEntity.setName(user.getName());
        userJpaEntity.setUserName(user.getUsername());
        userJpaEntity.setPassword(user.getPassword());
        userJpaEntity.setRole(user.getRole());
        return userJpaEntity;
    }
}