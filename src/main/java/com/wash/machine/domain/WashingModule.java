package com.wash.machine.domain;

import java.util.ArrayList;
import java.util.List;


public class WashingModule {

    private final List<ProgramModule> programs = new ArrayList<>();

    public WashingModule(ProgramModule... programs) {

        for (ProgramModule program : programs) {
            add(program);
        }


    }

    public void add(ProgramModule program) {
        for (ProgramModule next : programs) {
            if (next.getName().equals(program.getName())) {
                throw new IllegalArgumentException("Program" + program.getName() + "exist");


            }


        }
        programs.add(program);
    }
    public ProgramModule getProgram(int i) {
        if (i >= programs.size()) {
            // throw new IllegalArgumentException("Program index is out of range: " + i);
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

    public ProgramModule previousProgram(ProgramModule program) {
        int index = programs.indexOf(program);
        if (index == -1) {
            throw new IllegalArgumentException("Invalid program: " + program.getName());
        }
        if (--index < 0) {
            index = programs.size() - 1;
        }
        return programs.get(index);
    }
    public int number(ProgramModule program) {
        int index = programs.indexOf(program);
        if (index == -1) {
            throw new IllegalArgumentException("Invalid program: " + program.getName());
        }
        return index + 1;
    }
}


