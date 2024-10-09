package com.wash.machine.domain;

import java.util.ArrayList;
import java.util.List;

public class ProgramModule   {
        private final ProgramName name;
        private final int minV;
        private final int maxV;
        private final double minTemp;
        private final double maxTemp;
        private TempScale tempScale;

        public ProgramModule(ProgramName name, int minV, int maxV, double minTemp, double maxTemp, TempScale tempScale) {
                this.name = name;
                this.minV = minV;
                this.maxV = maxV;
                this.minTemp = minTemp;
                this.maxTemp = maxTemp;
                this.tempScale = tempScale;
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

        public double getMinTemp() {
                return minTemp;
        }

        public double getMaxTemp() {
                return maxTemp;
        }
}


