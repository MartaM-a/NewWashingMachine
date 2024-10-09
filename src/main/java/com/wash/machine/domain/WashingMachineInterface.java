package com.wash.machine.domain;

public interface WashingMachineInterface {
    boolean checkCapacity();
    void setProgram();
    void setTemperature();
    void setSpinSpeed();
    void setStartDelay();
    void showStatus();
    void addToHistory();

}
