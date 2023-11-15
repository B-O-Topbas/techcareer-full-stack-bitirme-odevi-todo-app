package com.beytullahonur.todoapp.domain.todo;

import java.util.Date;
import java.util.UUID;

public class Todo {
    private UUID id;
    private String todos;
    private boolean doneState;
    private Date creationDate;
    private UUID userId;

    public Todo() {
    }

    public Todo(String todos, boolean doneState) {
        this.todos = todos;
        this.doneState = doneState;
    }

    public Todo(String todos, boolean doneState, Date creationDate, UUID userId) {
        this.todos = todos;
        this.doneState = doneState;
        this.creationDate = creationDate;
        this.userId = userId;
    }

    public Todo(UUID id, String todos, boolean doneState, Date creationDate, UUID userId) {
        this.id = id;
        this.todos = todos;
        this.doneState = doneState;
        this.creationDate = creationDate;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTodos() {
        return todos;
    }

    public void setTodos(String todos) {
        this.todos = todos;
    }

    public boolean isDoneState() {
        return doneState;
    }

    public void setDoneState(boolean doneState) {
        this.doneState = doneState;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void updateTodo(String todos) throws IllegalAccessException {
        if ((!doneState)) {
            this.todos = todos;
        } else {
            throw new IllegalAccessException("Hatalı işlem");
        }
    }
}