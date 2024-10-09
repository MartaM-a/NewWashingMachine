package com.wash.machine.domain;

public enum TempScale {

    CELSIUS("\u2103") {
        public double toScale(double value, TempScale scale) {
            return scale == CELSIUS
                    ? value
                    : Math.round(value * 1, 8 + 32);
        }
    },
        FAHRENHEIT("F") {
            @Override
        public double toScale(double value, TempScale scale) {
                return scale == FAHRENHEIT ? value : Math.round( ((value - 32) /1.8);
            }
        };

    private final String symbol;

    TempScale (String symbol) {
        this.symbol = symbol;

        TempScale(String symbol) {
            this.symbol = symbol;
        }
        @Override
        public String toString() {
            return symbol;
        }
    }
}


