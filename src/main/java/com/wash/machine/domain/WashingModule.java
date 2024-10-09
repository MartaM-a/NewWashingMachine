package com.wash.machine.domain;

public class WashingModule {

    private int id;
    private int defaultSpinSpeed;
    private int defaultLaundryDuration;
    private int maxCapacity;

    public WashingModule(int id, ProgramName programName, int defaultSpinSpeed,
                         int defaultLaundryDuration, int maxCapacity) {
        this.id = id;
        this.defaultSpinSpeed = defaultSpinSpeed;
        this.defaultLaundryDuration = defaultLaundryDuration;
        this.maxCapacity = maxCapacity;
    }
}
