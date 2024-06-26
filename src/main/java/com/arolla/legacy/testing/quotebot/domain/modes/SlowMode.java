package com.arolla.legacy.testing.quotebot.domain.modes;

import com.arolla.legacy.testing.quotebot.domain.Mode;

public class SlowMode extends Mode {
    public SlowMode(String mode) {
        super();
    }

    @Override
    public double timeFactor() {
        return 2;
    }
}
