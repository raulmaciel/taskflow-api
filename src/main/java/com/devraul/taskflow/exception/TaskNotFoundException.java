package com.devraul.taskflow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(){
        super("Task não encontrada!");
    }

    public TaskNotFoundException(String message) {
        super(message);
    }
}
