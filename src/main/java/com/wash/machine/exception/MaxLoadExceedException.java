package com.wash.machine.exception;

public class MaxLoadExceedException extends RuntimeException{

    public MaxLoadExceedException(String message) {
        super( message);
    }
}
