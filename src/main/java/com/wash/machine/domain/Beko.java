package com.wash.machine.domain;

public class Beko extends WashingMachineLoad {
    public Beko() {
        super("Beko", 5.);
    }

    @Override
    protected double stepTemp() {
        return switch (getTemp().getScale()) {
            case CELSIUS -> 1.;
            case FAHRENHEIT -> 2.;
        };
    }
}

