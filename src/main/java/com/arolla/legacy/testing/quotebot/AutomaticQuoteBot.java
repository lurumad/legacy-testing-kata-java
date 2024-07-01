package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.quotebot.infrastructure.MarketStudyVendorAdapter;
import com.arolla.legacy.testing.quotebot.infrastructure.QuotePublisherAdapter;
import com.arolla.legacy.testing.quotebot.infrastructure.SystemClock;
import com.arolla.legacy.testing.thirdparty.quotebot.MarketStudyVendor;

public class AutomaticQuoteBot {
    public void sendAllQuotes(String mode) {
        var blogs = AdSpace.getAdSpaces();
        var auctionTask = new BlogAuctionTask(
                new MarketStudyVendorAdapter(new MarketStudyVendor()),
                new QuotePublisherAdapter(),
                new SystemClock()
        );
        for (String blog : blogs) {
            auctionTask.priceAndPublish(blog, mode);
        }
    }
}
