package com.wash.machine.domain;

import java.util.ArrayList;
import java.util.List;

import static java.awt.AWTEventMulticaster.add;

public class WashingModule {

    private final List<ProgramModule> programs = new ArrayList<>();

    public WashingModule(ProgramModule... programs) {

        for (ProgramModule program : programs) {
            add(program);
        }


    }

    public void add(ProgramModule program) {
        for (ProgramModule next : programs) {
            if (next.getName().equals((program.getName())) {
                throw new IllegalArgumentException("Program" + program.getName() + "exist");


            }
        }

    }


//    private int id;
//    private int defaultSpinSpeed;
//    private int defaultLaundryDuration;
//    private int maxCapacity;
//
//    public WashingModule(int id, ProgramName programName, int defaultSpinSpeed,
//                         int defaultLaundryDuration, int maxCapacity) {
//        this.id = id;
//        this.defaultSpinSpeed = defaultSpinSpeed;
//        this.defaultLaundryDuration = defaultLaundryDuration;
//        this.maxCapacity = maxCapacity;
//    }
//}
}