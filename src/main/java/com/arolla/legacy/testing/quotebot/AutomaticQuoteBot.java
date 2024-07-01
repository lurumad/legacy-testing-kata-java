package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.quotebot.infrastructure.MarketStudyVendorDataRetriever;
import com.arolla.legacy.testing.quotebot.infrastructure.PricePublisher;
import com.arolla.legacy.testing.thirdparty.quotebot.MarketStudyVendor;

public class AutomaticQuoteBot {

    public void sendAllQuotes(String mode) {
        var blogs = AdSpace.getAdSpaces();
        var auctionTask = new BlogAuctionTask(
                new MarketStudyVendorDataRetriever(new MarketStudyVendor()),
                new PricePublisher()
        );
        for (String blog : blogs) {
            auctionTask.priceAndPublish(blog, mode);
        }
    }
}
