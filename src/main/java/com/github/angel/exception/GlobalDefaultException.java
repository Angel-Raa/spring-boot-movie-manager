package com.github.angel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GlobalDefaultException extends RuntimeException implements Serializable {
     @Serial
     private static final long serialVersionUID = -9034897190745746939L;

    public GlobalDefaultException(String message) {
        super(message);
    }
}
