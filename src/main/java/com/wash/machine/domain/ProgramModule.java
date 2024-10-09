package com.wash.machine.domain;

import java.util.ArrayList;
import java.util.List;

public class ProgramModule  extends WashingModule {
        private static final int MIN_V = 0;
        private static final int MAX_V = 1000;
        private static final int SPIN_STEP = 100;
        private static final int DELICATE_MAX_V = 500;
        private int currentSpinSpeed;
        private double currentCapacity;

}
