package com.baron.Baron.TodoList.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class NotUniqueUsernameException extends RuntimeException {
    public NotUniqueUsernameException(String message) {
        super(message);
    }
}
