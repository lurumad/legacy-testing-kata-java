package com.arrolla.legacy.testing;

import com.arolla.legacy.testing.quotebot.BlogAuctionTask;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlogAuctionTaskTest extends BlogAuctionTask {
    private double averagePrice;
    private double proposal = 0.0;


    @ParameterizedTest
    @MethodSource("provideModes")
    public void priceAnPublishBlogInGivenMode(String mode, double averagePrice, double expectedProposal) {
        var blogAuctionTask = new BlogAuctionTaskTest();
        blogAuctionTask.averagePrice = averagePrice;
        blogAuctionTask.PriceAndPublish("blog", mode);
        assertEquals(expectedProposal, blogAuctionTask.proposal);
    }

    private static Stream<Arguments> provideModes() {
        return Stream.of(
                Arguments.of("SLOW", 0.0, 6.3),
                Arguments.of("SLOW", 1.0, 6.28),
                Arguments.of("MEDIUM", 0.0,  12.6),
                Arguments.of("MEDIUM", 1.0,  6.28),
                Arguments.of("FAST", 0.0, 25.2),
                Arguments.of("FAST", 1.0, 6.28),
                Arguments.of("ULTRAFAST", 0.0, 40.949999999999996),
                Arguments.of("ULTRAFAST", 1.0, 6.28)
        );
    }

    @Override
    protected double calculateAveragePrice(String blog) {
        return this.averagePrice;
    }

    @Override
    protected void publish(double proposal) {
        this.proposal = proposal;
    }

    @Override
    protected long timeDiff() {
        return 1;
    }

    private BlogAuctionTask createBlogAuctionTask(double averagePrice) {
        return new BlogAuctionTask() {
            @Override
            protected double calculateAveragePrice(String blog) {
                return averagePrice;
            }

            @Override
            protected void publish(double proposal) {
                BlogAuctionTaskTest.this.proposal = proposal;
            }

            @Override
            protected long timeDiff() {
                return 1;
            }
        };
    }
}
