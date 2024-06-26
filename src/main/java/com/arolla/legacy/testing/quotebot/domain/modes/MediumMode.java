package com.arolla.legacy.testing.quotebot.domain.modes;

import com.arolla.legacy.testing.quotebot.domain.Mode;

public class MediumMode extends Mode {
    public MediumMode(String mode) {
        super(mode);
    }

    @Override
    public double timeFactor() {
        return 4;
    }
}
