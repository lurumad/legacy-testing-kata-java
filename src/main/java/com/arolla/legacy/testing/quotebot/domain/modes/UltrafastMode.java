package com.arolla.legacy.testing.quotebot.domain.modes;

import com.arolla.legacy.testing.quotebot.domain.Mode;

public class UltrafastMode extends Mode {
    public UltrafastMode(String mode) {
        super();
    }

    @Override
    public double timeFactor() {
        return 13;
    }
}
