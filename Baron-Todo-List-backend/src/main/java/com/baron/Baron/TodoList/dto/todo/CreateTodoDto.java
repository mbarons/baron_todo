package com.baron.Baron.TodoList.dto.todo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CreateTodoDto {

    private String title;
    private String description;

}
