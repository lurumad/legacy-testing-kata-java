package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.quotebot.domain.Blog;
import com.arolla.legacy.testing.quotebot.domain.MarketDataRetriever;
import com.arolla.legacy.testing.quotebot.domain.Mode;
import com.arolla.legacy.testing.thirdparty.quotebot.QuotePublisher;

import java.util.Calendar;
import java.util.Date;

public class BlogAuctionTask {

    public static final int PRICE_ADJUSTMENT = 2;
    public static final double EVEN_PROPOSAL_MULTIPLIER = 3.14;
    public static final double ODD_PROPOSAL_MULTIPLIER = 3.15;
    private final MarketDataRetriever marketDataRetriever;
    protected double proposal;

    public BlogAuctionTask(MarketDataRetriever marketDataRetriever) {
        this.marketDataRetriever = marketDataRetriever;
    }


    public void priceAndPublish(String blogName, String modeName) {
        var proposal = calculateProposal(blogName, modeName);

        publish(proposal);
    }

    private double calculateProposal(String blogName, String modeName) {
        var mode = Mode.of(modeName);
        var blog = new Blog(blogName);
        var proposal = calculateInitialProposal(blog);

        proposal = isEven(proposal)
                ? calculateEvenProposal(proposal)
                : calculateOddProposal(mode);

        return proposal;
    }

    private double calculateInitialProposal(Blog blog) {
        return averagePrice(blog) + PRICE_ADJUSTMENT;
    }

    private static boolean isEven(double proposal) {
        return proposal % 2 == 0;
    }

    private static double calculateEvenProposal(double proposal) {
        return EVEN_PROPOSAL_MULTIPLIER * proposal;
    }

    @SuppressWarnings("deprecation")
    private double calculateOddProposal(Mode mode) {
        var date = new Date(2000, Calendar.JANUARY, 1);
        return ODD_PROPOSAL_MULTIPLIER * mode.timeFactor() * timeDiff(date);
    }

    protected long timeDiff(Date date) {
        return new Date().getTime() - date.getTime();
    }

    private double averagePrice(Blog blog) {
        return marketDataRetriever.averagePrice(blog);
    }

    protected void publish(double proposal) {
        QuotePublisher.INSTANCE.publish(proposal);
    }
}
