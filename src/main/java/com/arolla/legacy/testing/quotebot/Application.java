package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.quotebot.infrastructure.MarketStudyVendorAdapter;
import com.arolla.legacy.testing.quotebot.infrastructure.QuotePublisherAdapter;
import com.arolla.legacy.testing.quotebot.infrastructure.SystemClock;
import com.arolla.legacy.testing.thirdparty.quotebot.MarketStudyVendor;

public class Application {
    public static void main(String[] args) {
        AutomaticQuoteBot bot = new AutomaticQuoteBot(
                new MarketStudyVendorAdapter(new MarketStudyVendor()),
                new QuotePublisherAdapter(),
                new SystemClock()
        );
        bot.sendAllQuotes("FAST");
    }

}
