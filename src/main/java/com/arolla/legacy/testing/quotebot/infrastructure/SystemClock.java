package com.arolla.legacy.testing.quotebot.infrastructure;

import com.arolla.legacy.testing.quotebot.domain.Clock;

import java.util.Date;

public class SystemClock implements Clock {
    public long elapsedMilliseconds(Date date) {
        return new Date().getTime() - date.getTime();
    }
}
