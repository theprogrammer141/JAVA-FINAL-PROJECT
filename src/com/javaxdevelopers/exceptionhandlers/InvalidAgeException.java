package com.javaxdevelopers.exceptionhandlers;

public class InvalidAgeException extends Exception{
    public InvalidAgeException(String message) {
        super(message);
    }
}
