package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.quotebot.domain.Clock;
import com.arolla.legacy.testing.quotebot.infrastructure.MarketStudyVendorAdapter;
import com.arolla.legacy.testing.quotebot.infrastructure.QuotePublisherAdapter;

public class AutomaticQuoteBot {

    private final MarketStudyVendorAdapter marketDataRetriever;
    private final QuotePublisherAdapter publisher;
    private final Clock clock;
    private final AdSpace adSpace;

    public AutomaticQuoteBot(
            MarketStudyVendorAdapter marketDataRetriever,
            QuotePublisherAdapter publisher,
            Clock clock,
            AdSpace adSpace
    ) {
        this.marketDataRetriever = marketDataRetriever;
        this.publisher = publisher;
        this.clock = clock;
        this.adSpace = adSpace;
    }

    public void sendAllQuotes(String mode) {
        var blogs = adSpace.getAdSpaces();
        var auctionTask = new BlogAuctionTask(
                marketDataRetriever,
                publisher,
                clock
        );
        for (String blog : blogs) {
            auctionTask.priceAndPublish(blog, mode);
        }
    }
}
