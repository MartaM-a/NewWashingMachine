package com.wash.machine.domain;

public class TempModule {
    private TempScale scale;
    private double value;

    public double getValue() {
        return value;
    }

    public TempModule(double value, TempScale scale) {
        this.scale = scale;
        this.value = value;
    }

    public void tempUp(double step) {
        this.value += step;
    }

    public void tempDown(double step) {
        value -= step;
    }

    @Override
    public String toString() {
        return ((int)(value * 10))/10. + scale.toString();
    }

    public TempScale getScale() {
        return scale;
    }



    public boolean withinRange(ProgramModule program) {
        return this.value >= program.getMinTemp().toScale(this.scale).value
                && this.value <= program.getMaxTemp().toScale(this.scale).value;
    }



    public TempModule toScale(TempScale toScale) {
        return switch (this.scale) {
            case CELSIUS -> toScale == TempScale.CELSIUS ? this : new TempModule(Math.round(this.value * 1.8 + 32), toScale);
            case FAHRENHEIT -> toScale == TempScale.FAHRENHEIT ? this : new TempModule(Math.round((this.value - 32) / 1.8), toScale);
        };
    }
}


