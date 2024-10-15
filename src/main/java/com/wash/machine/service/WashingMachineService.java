package com.wash.machine.service;

import com.wash.machine.domain.ProgramName;
import com.wash.machine.domain.TempModule;
import com.wash.machine.domain.TempScale;
import com.wash.machine.domain.WashingMachine;

public class WashingMachineService {

    public void run (WashingMachine machine, ProgramName name, double temp, TempScale scale, int v ) {

        machine.setProgram(name);
        machine.setTemp (new TempModule(temp, scale));
        machine.setV(v);

        machine.start();
    }
}
