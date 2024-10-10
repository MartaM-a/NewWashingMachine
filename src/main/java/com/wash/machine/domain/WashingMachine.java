package com.wash.machine.domain;

public class WashingMachine {

    private static final int stepV = 100;
    private final String name;
    private final WashingModule programs;
    private final ProgramModule currentProgram;
    private int currentV;
    private final HistoryModule history;

    public WashingMachine (String name) {
        this(
                name,
                new WashingModule(
                        new ProgramModule(ProgramName.COTTON, 100,500,30, 50,TempScale.CELSIUS),
                        new




//                        new ProgramModule(SYNTHETIC, 100, 500, 35., 50., CELSIUS),
//                        new ProgramModule(DELICATE, 100, 500, 30., 40., CELSIUS),
//                        new ProgramModule(INTENSIVE, 100, 500, 35., 60., CELSIUS),
//                        new ProgramModule(QUICK, 100, 800, 30., 50., CELSIUS),
//                        new ProgramModule(WOOL, 100, 600, 30., 50., CELSIUS),
//                        new ProgramModule(SPORT, 100, 800, 30., 50., CELSIUS),
//                        new ProgramModule(ECO, 100, 400, 30., 50., CELSIUS),
//                        new ProgramModule(BABY, 100, 500, 40., 50., CELSIUS),
//                        new ProgramModule(SUPERQUICK, 100, 800, 30., 50., CELSIUS)
                )

                );


        )
    }
}
