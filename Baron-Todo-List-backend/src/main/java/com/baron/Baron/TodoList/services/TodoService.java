package com.baron.Baron.TodoList.services;

import com.baron.Baron.TodoList.exceptions.ResourceNotFoundException;
import com.baron.Baron.TodoList.dto.todo.TodoDto;
import com.baron.Baron.TodoList.mapper.DozerMapper;
import com.baron.Baron.TodoList.models.Todo;
import com.baron.Baron.TodoList.repositories.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private TodoRepository repository;

    public TodoDto create(TodoDto todoDto) {
        Todo todo = DozerMapper.parseObject(todoDto, Todo.class);
        repository.save(todo);
        TodoDto responseDto = DozerMapper.parseObject(todo, TodoDto.class);
        return responseDto;
    }

    public TodoDto finish(Long id) {
        Todo todo = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found"));
        todo.setDone(true);
        return DozerMapper.parseObject(todo, TodoDto.class);
    }

    public List<TodoDto> findAllByUser(String username) {
        return DozerMapper.parseListObjects(repository.findByUsername(username), TodoDto.class);
    }

}
