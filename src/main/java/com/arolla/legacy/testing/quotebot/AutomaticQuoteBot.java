package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.quotebot.domain.Clock;
import com.arolla.legacy.testing.quotebot.infrastructure.MarketStudyVendorAdapter;
import com.arolla.legacy.testing.quotebot.infrastructure.QuotePublisherAdapter;
import com.arolla.legacy.testing.quotebot.infrastructure.TechBlogsDbRepository;

public class AutomaticQuoteBot {

    private final MarketStudyVendorAdapter marketDataRetriever;
    private final QuotePublisherAdapter publisher;
    private final Clock clock;

    public AutomaticQuoteBot(
            MarketStudyVendorAdapter marketDataRetriever,
            QuotePublisherAdapter publisher,
            Clock clock
    ) {
        this.marketDataRetriever = marketDataRetriever;
        this.publisher = publisher;
        this.clock = clock;
    }

    public void sendAllQuotes(String mode) {
        var blogs = new AdSpace(new TechBlogsDbRepository()).getAdSpaces();
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
