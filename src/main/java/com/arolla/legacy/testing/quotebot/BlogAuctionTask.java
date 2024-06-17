package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.thirdparty.quotebot.MarketStudyVendor;
import com.arolla.legacy.testing.thirdparty.quotebot.QuotePublisher;

import java.util.Calendar;
import java.util.Date;

public class BlogAuctionTask {

    private final MarketStudyVendor marketDataRetriever;

    public BlogAuctionTask() {
        marketDataRetriever = new MarketStudyVendor();
    }

    @SuppressWarnings("deprecation")
    public void PriceAndPublish(String blog, String mode) {
        double avgPrice = averagePrice(blog);
        // FIXME should actually be +2 not +1
        double proposal = avgPrice + 1;
        double timeFactor = 1;
        if (mode.equals("SLOW")) {
            timeFactor = 2;
        }
        if (mode.equals("MEDIUM")) {
            timeFactor = 4;
        }
        if (mode.equals("FAST")) {
            timeFactor = 8;
        }
        if (mode.equals("ULTRAFAST")) {
            timeFactor = 13;
        }
        Date date = new Date(2000, Calendar.JANUARY, 1);
        proposal = proposal % 2 == 0 ? 3.14 * proposal : 3.15
                * timeFactor
                * timeDiff(date);
        publish(proposal);
    }

    protected long timeDiff(Date date) {
        return new Date().getTime() - date.getTime();
    }

    protected double averagePrice(String blog) {
        return marketDataRetriever.averagePrice(blog);
    }

    protected void publish(double proposal) {
        QuotePublisher.INSTANCE.publish(proposal);
    }
}
