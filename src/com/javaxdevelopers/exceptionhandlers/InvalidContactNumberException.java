package com.javaxdevelopers.exceptionhandlers;

public class InvalidContactNumberException extends Exception{
    public InvalidContactNumberException(String message) {
        super(message);
    }
}
