package com.beytullahonur.todoapp.infrastracture.todo;

import com.beytullahonur.todoapp.domain.todo.Todo;
import com.beytullahonur.todoapp.infrastracture.configuration.EntityMapper;
import com.beytullahonur.todoapp.infrastracture.todo.jpa.TodoJpaEntity;
import com.beytullahonur.todoapp.infrastracture.user.jpa.UserJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper implements EntityMapper<Todo, TodoJpaEntity> {
    @Override
    public Todo mapToDomainEntity(final TodoJpaEntity todoJpaEntity) {
       final  var todo=new Todo();
        todo.setId(todoJpaEntity.getId());
        todo.setTodos(todoJpaEntity.getTodo());
        todo.setDoneState(todoJpaEntity.isDoneState());
        todo.setCreationDate(todoJpaEntity.getCreationDate());
        if (todoJpaEntity.getUserJpaEntity()==null){
            todo.setUserId(null);
        }else  {
            todo.setUserId(todoJpaEntity.getUserJpaEntity().getId());
        }
        return todo;
    }

    @Override
    public TodoJpaEntity mapToJpaEntity(final Todo todo) {
        final var  todoJpaEntity=new TodoJpaEntity();
        todoJpaEntity.setId(todo.getId());
        todoJpaEntity.setTodo(todo.getTodos());
        todoJpaEntity.setDoneState(todo.isDoneState());
        todoJpaEntity.setCreationDate(todo.getCreationDate());
        todoJpaEntity.setUserJpaEntity(new UserJpaEntity(todo.getUserId()));
        return todoJpaEntity;
    }
}