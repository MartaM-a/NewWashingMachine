package com.wash.machine.domain;



    abstract class WashingMachine implements WashingMachineInterface {
        private ProgramModule programModule;
        private TempModule tempModule;
        private WashingHistoryModule historyModule;
        private int startDelay;

    }