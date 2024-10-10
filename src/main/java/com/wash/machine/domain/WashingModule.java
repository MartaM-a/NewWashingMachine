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
            if (next.getName().equals((program.getName()))) {
                throw new IllegalArgumentException("Program" + program.getName() + "exist");


            }
        }
        programs.add(program);
    }
    public ProgramModule getProgramModule(int i) {
        if (i >= programs.size()) {
            return programs.get(i);
        }

        public ProgramModule nextProgramModule(ProgramModule program) {
            int index = programs.indexOf(program);
        }
        return programs.get(i);
    }
    public ProgramModule nextProgram(ProgramModule program) {
        int index = programs.indexOf(program);
        if (index == -1) {
            throw new IllegalArgumentException("Invalid program: " + program.getName());
        }
        if (++index == programs.size()) {
            index = 0;
        }
        return programs.get(index);
    }
    public ProgramModule previosProgram (ProgramModule program) {
        int index = programs.indexOf(program);
        if (index == -1) {
            throw new IllegalArgumentException("Invalid program: " + program.getName());
        }
        if (--index < 0) {
            index = programs.size() - 1;
        }
        return programs.get(index);
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