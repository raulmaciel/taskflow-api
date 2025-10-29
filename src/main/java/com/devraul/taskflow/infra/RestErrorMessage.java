package com.devraul.taskflow.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class RestErrorMessage {
    private LocalDateTime timeStamp;
    private HttpStatus status;
    private String message;

    public RestErrorMessage(HttpStatus status, String message) {
        this.timeStamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
    }
}
