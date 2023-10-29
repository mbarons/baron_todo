package com.baron.Baron.TodoList.controllers;

import com.baron.Baron.TodoList.dto.todo.TodoDto;
import com.baron.Baron.TodoList.services.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto todoDto) {
        TodoDto responseDto = todoService.create(todoDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<TodoDto>> findTodoByUser(@PathVariable("username") String username) {
        List<TodoDto> dtoList = todoService.findAllByUser(username);
        return ResponseEntity.ok(dtoList);
    }

}
