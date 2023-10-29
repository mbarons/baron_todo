package com.baron.Baron.TodoList.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CreateUserDto {

    private String username;
    private String password;
    private String email;

}
