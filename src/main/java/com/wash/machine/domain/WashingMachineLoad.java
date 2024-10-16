package com.wash.machine.domain;


public class WashingMachineLoad extends WashingMachine {
    public static class LogWithWeight extends HistoryModule.Log{
        private final int loadPercent;


        public LogWithWeight(ProgramModule program, TempModule temp, int v, int loadPercent){
            super (program, temp,v);
            this.loadPercent = loadPercent;
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

}
   @Override
 public double getLoad() {
       return this.currentLoad;
    }
   @Override
  public double maxLoad() {
       return this.maxLoad;
    }
    @Override
     protected HistoryModule.Log createLog(){
       return new LogWithWeight(getProgram(), getTemp(), getV(), (int) (getLoad() * 100 / maxLoad ()));

    }

}

