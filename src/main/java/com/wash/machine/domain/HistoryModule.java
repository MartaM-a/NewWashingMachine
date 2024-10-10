package com.wash.machine.domain;

import java.util.ArrayList;

import java.util.List;


public class HistoryModule {
    public static class Log {
        private final ProgramName name;
        private final TempModule temp;
        private final int v;

        public Log(ProgramModule program, TempModule temp, int v) {
            this.name = program.getName();
            this.temp = temp;
            this.v = v;
        }

        public ProgramName getName() {
            return name;
        }

        public TempModule getTemp() {
            return temp;
        }

        public int getV() {
            return v;
        }

        @Override
        public String toString() {
            return "name=" + name
                    +", temp=" + temp
                    + ", v=" + v;
        }
    }

    private static final int MAX_SIZE = 30;

    private final List<Log> logs = new ArrayList<>();

    public void add(Log log) {
        if (this.logs.size() == MAX_SIZE) {
            this.logs.remove(MAX_SIZE - 1);
        }
        this.logs.add(0, log);
    }

    public List<Log> getLogs() {
        return logs;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (Log log : logs) {
            b.append(log.toString())
                    .append("\n");
        }
        return b.toString();
    }
}


