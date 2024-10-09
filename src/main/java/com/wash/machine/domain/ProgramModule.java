package com.wash.machine.domain;

import java.util.ArrayList;
import java.util.List;

public class ProgramModule   {
        private final ProgramName name;
        private final int minV;
        private  final int maxV;
        private static final int SPIN_STEP = 100;
        private static final int DELICATE_MAX_V = 500;
        private int currentSpinSpeed;
        private double currentCapacity;


        private double currentTemp;
        private TempScale tempScale;
        private double stepTemp;
}


