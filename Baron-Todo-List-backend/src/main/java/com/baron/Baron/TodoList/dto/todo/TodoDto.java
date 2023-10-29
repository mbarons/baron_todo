package com.baron.Baron.TodoList.dto.todo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
public class TodoDto {

    private Long id;
    private String title;
    private String description;
    private boolean done;
    private LocalDate dueDate;
    private String username;

}
