package com.wash.machine;


import com.wash.machine.domain.*;

import java.security.SecureRandom;

import static com.wash.machine.domain.TempScale.FAHRENHEIT;
import static java.lang.System.out;

public class Main {
    private static final SecureRandom RANDOM = new SecureRandom();

    public static void main(String[] args) {
        run(new Beko());
        run(new Whirlpool());
        run(new Amica());
    }


    private static void run(WashingMachine machine) {

        out.println("Set up a program");
        machine.setProgram(0);
        for (int run = 0; run < 30; run++) {


            out.println("Switch to next program");
            for (int i = 0; i < RANDOM.nextInt(15); i++) {
                machine.nextProgram();
            }
            for (int i = 0; i < RANDOM.nextInt(2); i++) {
                machine.previousProgram();
            }
            out.println("Set up a temperature");
            for (int i = 0; i < RANDOM.nextInt(4); i++) {
                machine.tempUp();
            }

            for (int i = 0; i < RANDOM.nextInt(20); i++) {
                machine.tempDown();
            }

            for (int i = 0; i < RANDOM.nextInt(2); i++) {
                machine.tempScale(FAHRENHEIT);
                out.println("Switch a scale");
            }

            out.println("Raise a speed");
            for (int i = 0; i < RANDOM.nextInt(2); i++) {
                machine.upV();
            }


            machine.showStatus();

            out.println("Start");
            machine.start();
        }

        machine.showHistory();


        out.println("\n----------------------------------------------------------------\n");
    }


}
