package com.wash.machine.domain;

import java.util.LinkedList;
import java.util.Map;

public class WashingHistoryModule {
    private LinkedList<Map<String, Object>> history;
    private static final int MAX_HISTORY = 30;

    public WashingHistoryModule() {

        this.history = new LinkedList<>();
    }
}