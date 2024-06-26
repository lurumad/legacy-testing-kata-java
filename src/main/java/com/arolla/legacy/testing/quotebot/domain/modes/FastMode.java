package com.arolla.legacy.testing.quotebot.domain.modes;

import com.arolla.legacy.testing.quotebot.domain.Mode;

public class FastMode extends Mode {
    public FastMode(String mode) {
        super(mode);
    }

    @Override
    public double timeFactor() {
        return 8;
    }
}
