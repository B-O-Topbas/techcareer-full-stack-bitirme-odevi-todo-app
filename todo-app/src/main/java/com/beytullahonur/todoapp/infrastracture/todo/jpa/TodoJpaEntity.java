package com.beytullahonur.todoapp.infrastracture.todo.jpa;

import com.beytullahonur.todoapp.infrastracture.user.jpa.UserJpaEntity;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "todo")
public class TodoJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String todo;
    private boolean doneState;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserJpaEntity userJpaEntity;

    public TodoJpaEntity() {
    }

    public TodoJpaEntity(String todo, boolean doneState) {
        this.todo = todo;
        this.doneState = doneState;
    }

    public TodoJpaEntity(String todo, boolean doneState, Date creationDate, UserJpaEntity userJpaEntity) {
        this.todo = todo;
        this.doneState = doneState;
        this.creationDate = creationDate;
        this.userJpaEntity = userJpaEntity;
    }

    public TodoJpaEntity(UUID id, String todo, boolean doneState, Date creationDate, UserJpaEntity userJpaEntity) {
        this.id = id;
        this.todo = todo;
        this.doneState = doneState;
        this.creationDate = creationDate;
        this.userJpaEntity = userJpaEntity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
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

    public UserJpaEntity getUserJpaEntity() {
        return userJpaEntity;
    }

    public void setUserJpaEntity(UserJpaEntity userJpaEntity) {
        this.userJpaEntity = userJpaEntity;
    }
}