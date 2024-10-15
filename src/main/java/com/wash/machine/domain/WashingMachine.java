package com.wash.machine.domain;


import com.wash.machine.exception.SpeedOutOfRangeException;
import com.wash.machine.exception.TemperatureIsOutOfRange;

import java.util.List;

public class WashingMachine {

    public static final int STEP_V = 100;
    private final String name;
    private final WashingModule programs;
    private ProgramModule currentProgram;
    private TempModule currentTemp;
    private int currentV;
    private final HistoryModule history;

    public WashingMachine(String name) {
        this(
                name,
                new WashingModule(
                        new ProgramModule(ProgramName.COTTON, 100, 500, 30, 50, TempScale.CELSIUS),
                        new ProgramModule(ProgramName.SYNTHETIC, 100, 500, 30, 40, TempScale.CELSIUS),
                        new ProgramModule(ProgramName.DELICATE, 100, 500, 30, 40, TempScale.CELSIUS),
                        new ProgramModule(ProgramName.INTENSIVE, 100, 500, 35, 60, TempScale.CELSIUS),
                        new ProgramModule(ProgramName.QUICK, 100, 500, 35, 60, TempScale.CELSIUS),
                        new ProgramModule(ProgramName.WOOL, 100, 600, 30, 50, TempScale.CELSIUS),
                        new ProgramModule(ProgramName.SPORT, 100, 800, 30, 50, TempScale.CELSIUS),
                        new ProgramModule(ProgramName.ECO, 100, 400, 30, 50, TempScale.CELSIUS),
                        new ProgramModule(ProgramName.BABY, 100, 500, 40, 50, TempScale.CELSIUS),
                        new ProgramModule(ProgramName.SUPERQUICK, 100, 800, 30, 50, TempScale.CELSIUS)

                )


        );

    }


    protected WashingMachine(String name, WashingModule programs) {
        this.name = name;
        this.programs = programs;
        this.currentTemp = new TempModule(0, TempScale.CELSIUS);
        this.history = new HistoryModule();
    }

    public ProgramModule setProgram(ProgramName name) {
        return setProgram(programs.getProgram(name));
    }

    public ProgramModule getProgram(ProgramName name)  {
        return programs.getProgram(name);
    }

    public ProgramModule nextProgram() {
        return setProgram(programs.nextProgram(this.currentProgram));
    }

    public ProgramModule previousProgram() {
        return setProgram(programs.previousProgram(this.currentProgram));
    }

    private ProgramModule setProgram(ProgramModule program) {
        this.currentProgram = program;
        this.setTemp(program.getMinTemp());
        this.setV(program.getMinV());
        return this.currentProgram;
    }

    public TempModule getTemp() {
        return this.currentTemp;
    }


    public void setTemp(TempModule temp) {
        if (!temp.withinRange(this.currentProgram)) {
            throw new TemperatureIsOutOfRange("Temperature is out of range");
        }

        this.currentTemp = temp;
    }

    public void tempUp() {
        this.currentTemp.tempUp(stepTemp());

        // limit max temp
        if (!this.currentTemp.withinRange(this.currentProgram)) {
            this.currentTemp = this.currentProgram.getMaxTemp().toScale(this.currentTemp.getScale());
        }
    }

    public void tempDown() {
        this.currentTemp.tempDown(stepTemp());

        // limit min temp
        if (!this.currentTemp.withinRange(this.currentProgram)) {
            this.currentTemp = this.currentProgram.getMinTemp().toScale(this.currentTemp.getScale());
        }
    }

    protected double stepTemp() {
        return switch (this.currentTemp.getScale()) {
            case CELSIUS -> 0.5;
            case FAHRENHEIT -> 1.;
        };
    }

    public void tempScale(TempScale scale) {
        this.currentTemp = this.currentTemp.toScale(scale);
    }

    public void setV(int v) {
        if (v < this.currentProgram.getMinV()
                || v > this.currentProgram.getMaxV()) {
            throw new SpeedOutOfRangeException("Speed is out of range: " + v);
        }
        if (v % STEP_V != 0) {
            throw new SpeedOutOfRangeException("Speed should be a power of " + STEP_V + " but was: " + v);
        }
        this.currentV = v;
    }

    public int getV() {
        return this.currentV;
    }

    public void upV() {
        if (this.currentV == this.currentProgram.getMaxV()) {
            throw new SpeedOutOfRangeException("Speed is out of range: " + this.currentProgram.getMaxV());
        }
        this.currentV += STEP_V;
    }

    public void downV() {
        if (this.currentV == this.currentProgram.getMinV()) {
            throw new SpeedOutOfRangeException("Speed is out of range: " + this.currentProgram.getMinV());
        }
        this.currentV -= STEP_V;
    }


    public void start() {


        this.history.add(createLog());
    }


    protected HistoryModule.Log createLog() {
        return new HistoryModule.Log(this.currentProgram, this.currentTemp, this.currentV);
    }

//    public HistoryModule getHistory() {
//        return history;
//    }



    public void showStatus() {

        System.out.println("\t" + name + ". Current program " + this.programs.number(this.currentProgram) + " " + this.currentProgram
                + " at temperature " + this.currentTemp
                + ", speed " + this.currentV

        );
    }

    public void showHistory() {
        System.out.println("History:\n" + history);
    }


    public List<ProgramName> getPrograms() {
        return programs.getNames ();

    }
}
