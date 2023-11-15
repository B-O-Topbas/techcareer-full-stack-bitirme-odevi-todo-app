package com.beytullahonur.todoapp.domain.user;

import java.util.UUID;

public interface UserRepository {
    void  saveUser(User user);
    User findUserById(UUID id);
    boolean checkUserIsExist(String userName);
    User findUserByUserName(String userName);
}