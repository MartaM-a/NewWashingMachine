package com.wash.machine.domain;


import static com.wash.machine.domain.ProgramName.*;
import static com.wash.machine.domain.TempScale.CELSIUS;

public class Whirlpool extends WashingMachine {
    public Whirlpool() {
        super(
                "Whirlpool",
                new WashingModule(
                        new ProgramModule(COTTON, 100, 500, 30, 50, CELSIUS),
                        new ProgramModule(SYNTHETIC, 100, 500, 30, 40, CELSIUS),
                        new ProgramModule(DELICATE, 100, 500, 30, 40, CELSIUS),
                        new ProgramModule(INTENSIVE, 100, 500, 35, 60, CELSIUS),
                        new ProgramModule(QUICK, 100, 500, 35, 60, CELSIUS),
                        new ProgramModule(WOOL, 100, 600, 30, 50, CELSIUS),
                        new ProgramModule(SPORT, 100, 800, 30, 50, CELSIUS),
                        new ProgramModule(ECO, 100, 400, 30, 50, CELSIUS),
                        new ProgramModule(BABY, 100, 500, 40, 50, CELSIUS),
                        new ProgramModule(SUPERQUICK, 100, 800, 30, 50, CELSIUS),

                        new ProgramModule(EXTRA1, 400, 1000, 50, 90, CELSIUS),
                        new ProgramModule(EXTRA2, 600, 1000, 30, 90, CELSIUS),
                        new ProgramModule(EXTRA3, 200, 900, 60, 90, CELSIUS),
                        new ProgramModule(EXTRA4, 800, 900, 45, 60, CELSIUS),
                        new ProgramModule(EXTRA5, 300, 1000, 30, 60, CELSIUS)

                )


        );




    }
}