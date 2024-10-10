package com.wash.machine.exception;

public class TemperatureIsOutOfRange extends RuntimeException{
    public TemperatureIsOutOfRange(String message) {

        super(message);
    }

}
