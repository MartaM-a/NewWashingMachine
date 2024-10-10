package com.wash.machine.domain;

public class Beko extends WashingMachine {
    public Beko() {
        super("Beko");
    }

    @Override
    protected double stepTemp() {
        return switch (getTemp().getScale()) {
            case CELSIUS -> 1.;
            case FAHRENHEIT -> 2.;
        };
    }
}

