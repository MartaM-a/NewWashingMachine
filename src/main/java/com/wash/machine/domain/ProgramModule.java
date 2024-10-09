package com.wash.machine.domain;

import java.util.ArrayList;
import java.util.List;

public class ProgramModule   {
        private final int MIN_V = 0;
        private  final int MAX_V = 1000;
        private static final int SPIN_STEP = 100;
        private static final int DELICATE_MAX_V = 500;
        private int currentSpinSpeed;
        private double currentCapacity;

        private static final double MAX_TEMP = 90.0;
        private static final double MIN_TEMP = 30.0;
        private double currentTemp;
        private TempScale tempScale;
        private double stepTemp;
}


