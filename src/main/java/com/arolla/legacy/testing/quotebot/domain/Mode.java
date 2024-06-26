package com.arolla.legacy.testing.quotebot.domain;

import com.arolla.legacy.testing.quotebot.domain.modes.*;

public abstract class Mode {

    public static Mode of(String mode) {
        return switch (mode) {
            case "SLOW" -> new SlowMode();
            case "MEDIUM" -> new MediumMode();
            case "FAST" -> new FastMode();
            case "ULTRAFAST" -> new UltrafastMode();
            default -> new UnknownMode();
        };
    }

    public abstract double timeFactor();
}