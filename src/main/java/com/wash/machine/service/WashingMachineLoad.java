package com.wash.machine.service;

import com.wash.machine.domain.HistoryModule;
import com.wash.machine.domain.ProgramModule;
import com.wash.machine.domain.TempModule;
import com.wash.machine.domain.WashingMachine;


public class WashingMachineLoad extends WashingMachine {
    public static class LogWithWeight extends HistoryModule.Log{
        private final int loadPercent;


        public LogWithWeight(ProgramModule program, TempModule temp, int v, int loadPercent){
            super (program, temp,v);
            this.loadPercent;
        }

        public int getLoadPercent () {
            return this.loadPercent;
        }

        @Override
        public String toString() {
            return super.toString()
                    + ", %=" + loadPercent;
        }
    }
    public final double maxLoad;
    private double currentLoad;

    public WashingMachineLoad (String name, double maxLoad) {
        super(name);
        this.maxLoad =maxLoad;

    }
public void setLoad (double load) {
        this.currentLoad = load;


   @Override
 public double getLoad() {
       return this.maxLoad;
    }
   @Override
  public double maxLoad() {
       return this.maxLoad;
    }
    @Override
     protected HistoryModule.Log createLog(){
       return new LogWithWeight(getProgram(), getTemp(), getV(), (int) (this.currentLoad * 100/ this.maxLoad));

    }

}
}
