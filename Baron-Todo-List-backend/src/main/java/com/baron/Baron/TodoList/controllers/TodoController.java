package com.baron.Baron.TodoList.controllers;

import com.baron.Baron.TodoList.dto.todo.CreateTodoDto;
import com.baron.Baron.TodoList.dto.todo.TodoDto;
import com.baron.Baron.TodoList.services.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping()
    public ResponseEntity<TodoDto> createTodo(@RequestBody CreateTodoDto createTodoDto, Authentication authentication) {
        TodoDto responseDto = todoService.create(createTodoDto, authentication.getName());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @GetMapping()
    public ResponseEntity<List<TodoDto>> findTodoByUser(Authentication authentication) {
        List<TodoDto> dtoList = todoService.findAllByUser(authentication.getName());
        return ResponseEntity.ok(dtoList);
    }

}
