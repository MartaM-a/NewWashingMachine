package com.wash.machine.domain;

public interface WashingMachineInterface {
    boolean checkCapacity(double weight);
    void setProgram(ProgramName program);
    void setTemperature(double temperature);
    void setSpinSpeed(int speed);
    void setStartDelay(int minutes);
    void showStatus();
    void addToHistory();

}
