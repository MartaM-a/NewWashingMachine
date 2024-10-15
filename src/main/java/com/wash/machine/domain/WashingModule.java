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
            if (next.getName().equals(program.getName())){
                throw new IllegalArgumentException("Program " + program.getName() + " already exists");
            }


        }
        programs.add(program);
    }
    public ProgramModule getProgram(ProgramName name) {
        for (ProgramModule next : programs) {
            if (next.getName().equals(name)) {
                return next;
            }

        }
        throw new IllegalArgumentException("Program " + name + " not found" );
    }


    public ProgramModule nextProgram(ProgramModule program) {
        int index = programs.indexOf(program);

        if (++index == programs.size()) {
            index = 0;
        }
        return programs.get(index);
    }

    public ProgramModule previousProgram(ProgramModule program) {
        int index = programs.indexOf(program);

        if (--index < 0) {
            index = programs.size() - 1;
        }
        return programs.get(index);
    }
    public int number(ProgramModule program) {
        int index = programs.indexOf(program);

        return index + 1;
    }

    public List<ProgramName> getNames() {
        List <ProgramName> names = new ArrayList<>();
        for (ProgramModule program : programs){
            names.add(program.getName());


        }
        return names;
    }
}


