package com.arolla.legacy.testing.quotebot.infrastructure;

import com.arolla.legacy.testing.quotebot.domain.Publisher;
import com.arolla.legacy.testing.thirdparty.quotebot.QuotePublisher;

public class PricePublisher implements Publisher {
    @Override
    public void publish(double proposal) {
        QuotePublisher.INSTANCE.publish(proposal);
    }
}
