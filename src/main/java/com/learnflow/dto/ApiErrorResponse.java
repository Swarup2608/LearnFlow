package com.learnflow.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class ApiErrorResponse {
    
    private LocalDateTime timestamp; // Timestamp of the error
    private int status; // HTTP status code
    private String message; // Error message
    private Map<String, String> errors; // Validation errors if any

    public ApiErrorResponse(LocalDateTime timestamp, int status, String message, Map<String, String> errors) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    // Getters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}