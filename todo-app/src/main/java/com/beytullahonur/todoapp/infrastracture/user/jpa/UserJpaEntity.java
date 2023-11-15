package com.beytullahonur.todoapp.infrastracture.user.jpa;

import com.beytullahonur.todoapp.infrastracture.todo.jpa.TodoJpaEntity;
import com.beytullahonur.todoapp.infrastracture.user.Role;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "userr")
public class UserJpaEntity  implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "userJpaEntity")
    List<TodoJpaEntity> todoJpaEntities;

    public UserJpaEntity() {
    }

    public UserJpaEntity(UUID id) {
        this.id=id;
    }
    public UserJpaEntity(UUID id, String name, String userName, String password,Role role, List<TodoJpaEntity> todoJpaEntities) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.todoJpaEntities = todoJpaEntities;
        this.role=role;
    }

    public UserJpaEntity(String name, String userName, String password,Role role, List<TodoJpaEntity> todoJpaEntities) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.todoJpaEntities = todoJpaEntities;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TodoJpaEntity> getTodoJpaEntities() {
        return todoJpaEntities;
    }

    public void setTodoJpaEntities(List<TodoJpaEntity> todoJpaEntities) {
        this.todoJpaEntities = todoJpaEntities;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}