package com.arolla.legacy.testing.quotebot.domain;

public class Mode {
    private final String mode;

    public Mode(String mode) {
        this.mode = mode;
    }

    public double timeFactor() {
        double timeFactor = 1;
        if (mode.equals("SLOW")) {
            timeFactor = 2;
        }
        if (mode.equals("MEDIUM")) {
            timeFactor = 4;
        }
        if (mode.equals("FAST")) {
            timeFactor = 8;
        }
        if (mode.equals("ULTRAFAST")) {
            timeFactor = 13;
        }
        return timeFactor;
    }
}