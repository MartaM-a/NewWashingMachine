package com.wash.machine;


import com.wash.machine.domain.*;
import com.wash.machine.domain.WashingMachineLoad;
import com.wash.machine.service.WashingMachineService;

import java.security.SecureRandom;
import java.util.List;

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
            TempScale scale = program.getMaxTemp().getScale();
            if (RANDOM.nextInt(2) == 1){
               temp =  new TempModule(temp, scale ).toScale(TempScale.FAHRENHEIT).getValue();
               scale = TempScale.FAHRENHEIT;

            }

            int V = RANDOM.nextInt(program.getMinV()/WashingMachine.STEP_V, program.getMaxV()/WashingMachine.STEP_V +1 ) * WashingMachine.STEP_V;

            if (machine instanceof WashingMachineLoad){
                ((WashingMachineLoad) machine).setLoad(RANDOM.nextDouble((int) (machine.maxLoad() * 100/2)) / 100.);
            }
            service.run(machine, name, temp, scale, V);





        }


        machine.showStatus();

        machine.showHistory();

        showOptimalWashRuns(machine);

        System.out.println("\n----------------------------------------------------------------\n");
    }
    private static void showOptimalWashRuns(WashingMachine machine1) {
        int optimization  = 0;
        int count  = 0;
        int loadPercent = 0;
      for (HistoryModule.Log log : machine1.getHistory().getLogs()){

          if (log instanceof WashingMachineLoad.LogWithWeight){
              int thisloadPercent =((WashingMachineLoad.LogWithWeight)log).getLoadPercent();

              if (loadPercent + thisloadPercent > 100) {
                  if (count > 1) {
                      ++optimization;
                      System.out.println("There are " + count + " program that might be optimized with load percent " + loadPercent);
                  }

                  loadPercent = 0;
                  count = 0 ;
                  }
              loadPercent += thisloadPercent;
              ++count;

              } else {
              loadPercent = 0;
              count = 0;
          }
      }
      if (count > 1) {
          ++optimization;
          System.out.println("There are " + count + "program that might be optimized with load percent " + loadPercent);
      }

      if (optimization == 0 ){
          System.out.println("There are no programs that might be optimized");
      }

    }


}
