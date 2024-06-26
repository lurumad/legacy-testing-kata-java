package com.arolla.legacy.testing.quotebot.domain.modes;

import com.arolla.legacy.testing.quotebot.domain.Mode;

public class UnknownMode extends Mode {

    @Override
    public double timeFactor() {
        return 1;
    }
}
