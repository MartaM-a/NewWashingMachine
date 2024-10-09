package com.wash.machine.domain;

public enum TempScale {

    CELSIUS("\u2103"), FAHRENHEIT("F");

    private final String symbol;

    TempScale(String symbol) {
        this.symbol = symbol;
    }


}



