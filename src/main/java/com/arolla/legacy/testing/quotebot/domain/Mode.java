package com.arolla.legacy.testing.quotebot.domain;

import com.arolla.legacy.testing.quotebot.domain.modes.SlowMode;

public class Mode {
    private final String mode;

    public Mode(String mode) {
        this.mode = mode;
    }

    public static Mode of(String mode) {
        switch (mode) {
            case "SLOW":
                return new SlowMode(mode);
            default:
                return new Mode(mode);
        }
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