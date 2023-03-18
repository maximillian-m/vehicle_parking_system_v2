package com.Maximillian.vehicleparkingsystem.exception;

public class ResourceNotFoundException extends RuntimeException{
    protected String message;

    public ResourceNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
