package com.apple.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(value = HttpStatus.FOUND)
public class UserNotFoundException extends Exception implements Serializable {
    public UserNotFoundException(String message) {
        super(message);
    }
}