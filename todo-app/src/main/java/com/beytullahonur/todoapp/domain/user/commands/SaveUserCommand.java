package com.beytullahonur.todoapp.domain.user.commands;

public record SaveUserCommand(String name, String userName, String password) {
}