package com.wash.machine.domain;


public class ProgramModule   {
        private final ProgramName name;
        private final int minV;
        private final int maxV;
        private final double minTemp;
        private final double maxTemp;
        private TempScale scale;

        public ProgramModule(ProgramName name, int minV, int maxV, double minTemp, double maxTemp, TempScale tempScale) {
                this.name = name;
                this.minV = minV;
                this.maxV = maxV;
                this.minTemp = minTemp;
                this.maxTemp = maxTemp;
                this.scale = tempScale;
        }

        public int getMinV() {
                return minV;
        }

        public int getMaxV() {
                return maxV;
        }

        public ProgramName getName() {
                return name;
        }

        public TempModule getMinTemp() {
                return new TempModule(minTemp, scale);
        }

        public TempModule getMaxTemp() {

                return new TempModule(maxTemp, scale);
        }

        @Override
        public String toString() {
                return name.toString();
        }
}


