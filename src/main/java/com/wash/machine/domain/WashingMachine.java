package com.wash.machine.domain;

public class WashingMachine {

    private static final int stepV = 100;
    private final String name;
    private final WashingModule programs;
    private final ProgramModule currentProgram;
    private int CurrentV;
    private final HistoryModule history;

    public WashingMachine (String name) {
        this(name,
                new ProgramModule(   new WashingModule(), 100, 500, 30., 50., CELSIUS),
                        new WashingModule(SYNTHETIC, 100, 500, 35., 50., CELSIUS),
                        new WashingModule(DELICATE, 100, 500, 30., 40., CELSIUS),
                        new WashingModule(INTENSIVE, 100, 500, 35., 60., CELSIUS),
                        new WashingModule(QUICK, 100, 800, 30., 50., CELSIUS),
                        new WashingModule(WOOL, 100, 600, 30., 50., CELSIUS),
                        new WashingModule(SPORT, 100, 800, 30., 50., CELSIUS),
                        new WashingModule(ECO, 100, 400, 30., 50., CELSIUS),
                        new WashingModule(BABY, 100, 500, 40., 50., CELSIUS),
                        new WashingModule(SUPERQUICK, 100, 800, 30., 50., CELSIUS)
                );

                );


        )
    }
}
