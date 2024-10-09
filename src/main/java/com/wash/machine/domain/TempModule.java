package com.wash.machine.domain;

public class TempModule {
private TempScale scale;
private  double maxTemp;
private  double minTemp;
private double currentTemp;



    public TempModule(TempScale scale, double maxTemp, double minTemp, double currentTemp) {
        this.scale = scale;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.currentTemp = currentTemp;
    }

    public void tempUp() {
        switch (scale) {
            case CELSIUS:
                currentTemp += 0.5;
            case FAHRENHEIT:
                currentTemp += 1;

        }
    }

    public void tempDown() {
        switch (scale) {
            case CELSIUS:
                currentTemp -= 0.5;
            case FAHRENHEIT:
                currentTemp -= 1;

        }
    }

    @Override
    public String toString() {
        return currentTemp + scale.toString();
    }

    public TempScale getScale() {
        return scale;
    }

    public void setScale(TempScale scale) {
        this.scale = scale;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(double currentTemp) {
        this.currentTemp = currentTemp;
    }
}


