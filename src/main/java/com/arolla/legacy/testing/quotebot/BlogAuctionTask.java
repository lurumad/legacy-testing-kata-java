package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.quotebot.domain.Mode;
import com.arolla.legacy.testing.thirdparty.quotebot.MarketStudyVendor;
import com.arolla.legacy.testing.thirdparty.quotebot.QuotePublisher;

import java.util.Calendar;
import java.util.Date;

public class BlogAuctionTask {

    public static final int PRICE_ADJUSTMENT = 2;
    public static final double EVEN_PROPOSAL_MULTIPLIER = 3.14;
    public static final double ODD_PROPOSAL_MULTIPLIER = 3.15;
    private final MarketStudyVendor marketDataRetriever;

    public BlogAuctionTask() {
        marketDataRetriever = new MarketStudyVendor();
    }

    @SuppressWarnings("deprecation")
    public void PriceAndPublish(String blog, String modeName) {
        var proposal = calculateInitialProposal(blog);
        var mode = new Mode(modeName);
        var timeFactor = mode.timeFactor();
        var date = new Date(2000, Calendar.JANUARY, 1);
        proposal = isEven(proposal)
                ? calculateEvenProposal(proposal)
                : calculateOddProposal(timeFactor, date);
        publish(proposal);
    }

    private double calculateInitialProposal(String blog) {
        return averagePrice(blog) + PRICE_ADJUSTMENT;
    }

    private static boolean isEven(double proposal) {
        return proposal % 2 == 0;
    }

    private static double calculateEvenProposal(double proposal) {
        return EVEN_PROPOSAL_MULTIPLIER * proposal;
    }

    private double calculateOddProposal(double timeFactor, Date date) {
        return ODD_PROPOSAL_MULTIPLIER * timeFactor * timeDiff(date);
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
