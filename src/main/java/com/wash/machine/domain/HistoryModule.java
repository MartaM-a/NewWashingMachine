package com.wash.machine.domain;

import java.util.LinkedList;
import java.util.Map;

public class HistoryModule {
    private LinkedList<Map<String, Object>> history;
    private static final int MAX_HISTORY = 30;

    public HistoryModule() {

        this.history = new LinkedList<>();
    }
}