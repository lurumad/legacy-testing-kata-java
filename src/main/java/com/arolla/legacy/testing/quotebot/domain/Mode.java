package com.arolla.legacy.testing.quotebot.domain;

import com.arolla.legacy.testing.quotebot.domain.modes.*;

public abstract class Mode {

    public static Mode of(String mode) {
        return switch (mode) {
            case "SLOW" -> new SlowMode(mode);
            case "MEDIUM" -> new MediumMode(mode);
            case "FAST" -> new FastMode(mode);
            case "ULTRAFAST" -> new UltrafastMode(mode);
            default -> new UnknownMode(mode);
        };
    }

    public abstract double timeFactor();
}