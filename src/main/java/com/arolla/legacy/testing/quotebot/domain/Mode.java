package com.arolla.legacy.testing.quotebot.domain;

import com.arolla.legacy.testing.quotebot.domain.modes.FastMode;
import com.arolla.legacy.testing.quotebot.domain.modes.MediumMode;
import com.arolla.legacy.testing.quotebot.domain.modes.SlowMode;
import com.arolla.legacy.testing.quotebot.domain.modes.UltrafastMode;

public class Mode {
    private final String mode;

    public Mode(String mode) {
        this.mode = mode;
    }

    public static Mode of(String mode) {
        switch (mode) {
            case "SLOW":
                return new SlowMode(mode);
            case "MEDIUM":
                return new MediumMode(mode);
            case "FAST":
                return new FastMode(mode);
            case "ULTRAFAST":
                return new UltrafastMode(mode);
            default:
                return new Mode(mode);
        }
    }

    public double timeFactor() {
        return 1;
    }
}