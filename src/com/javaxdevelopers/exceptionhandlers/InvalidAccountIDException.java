package com.javaxdevelopers.exceptionhandlers;

public class InvalidAccountIDException extends Exception{
    public InvalidAccountIDException(String message) {
        super(message);
    }
}
