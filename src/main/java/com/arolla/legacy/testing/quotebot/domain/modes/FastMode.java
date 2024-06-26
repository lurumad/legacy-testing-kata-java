package com.arolla.legacy.testing.quotebot.domain.modes;

import com.arolla.legacy.testing.quotebot.domain.Mode;

public class FastMode extends Mode {
    public FastMode(String mode) {
        super();
    }

    @Override
    public double timeFactor() {
        return 8;
    }
}
