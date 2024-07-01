package com.arolla.legacy.testing.quotebot.domain;

import java.util.Date;

public interface Clock {
    long elapsedMilliseconds(Date date);
}
