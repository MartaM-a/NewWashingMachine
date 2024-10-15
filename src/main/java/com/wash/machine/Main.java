package com.wash.machine;


import com.wash.machine.domain.*;
import com.wash.machine.service.WashingMachineService;

import java.security.SecureRandom;
import java.util.List;


import static java.lang.System.out;

public class Main {
    private static final SecureRandom RANDOM = new SecureRandom();

    public static void main(String[] args) {
        run(new Beko());
        run(new Whirlpool());
        run(new Amica());
    }


    private static void run(WashingMachine machine) {
        WashingMachineService service = new WashingMachineService();
        List<ProgramName> programs = machine .getPrograms();
        for (int run = 0; run < 30; run++) {

            ProgramName name = programs.get(RANDOM.nextInt(programs.size()));
            ProgramModule program = machine.getProgram(name);


            double temp = RANDOM.nextDouble(program.getMinTemp().getValue(), program.getMaxTemp().getValue());


            int V = RANDOM.nextInt(program.getMinV()/WashingMachine.STEP_V, program.getMaxV()/WashingMachine.STEP_V +1 ) * WashingMachine.STEP_V;

            service.run(machine, name, temp,program.getMaxTemp().getScale(), V);


        }


        machine.showStatus();



        machine.showHistory();


        out.println("\n----------------------------------------------------------------\n");
    }


}
