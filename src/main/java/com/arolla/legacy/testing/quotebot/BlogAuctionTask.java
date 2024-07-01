package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.quotebot.domain.*;

import java.util.Calendar;
import java.util.Date;

public class BlogAuctionTask {

    public static final int PRICE_ADJUSTMENT = 2;
    public static final double EVEN_PROPOSAL_MULTIPLIER = 3.14;
    public static final double ODD_PROPOSAL_MULTIPLIER = 3.15;
    private final MarketDataRetriever marketDataRetriever;
    private final Publisher publisher;
    private final Clock clock;

    public BlogAuctionTask(
            MarketDataRetriever marketDataRetriever,
            Publisher publisher,
            Clock clock
    ) {
        this.marketDataRetriever = marketDataRetriever;
        this.publisher = publisher;
        this.clock = clock;
    }

    public void priceAndPublish(String blogName, String modeName) {
        var mode = Mode.of(modeName);
        var blog = new Blog(blogName);

        var proposal = calculateProposal(blog, mode);

        publisher.publish(proposal);
    }

    private double calculateProposal(Blog blog, Mode mode) {
        var proposal = calculateInitialProposal(blog);

        proposal = isEven(proposal)
                ? calculateEvenProposal(proposal)
                : calculateOddProposal(mode);

        return proposal;
    }

    private double calculateInitialProposal(Blog blog) {
        return marketDataRetriever.averagePrice(blog) + PRICE_ADJUSTMENT;
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
        return ODD_PROPOSAL_MULTIPLIER * mode.timeFactor() * this.clock.elapsedMilliseconds(date);
    }
}
