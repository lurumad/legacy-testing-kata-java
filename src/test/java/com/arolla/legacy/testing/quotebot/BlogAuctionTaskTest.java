package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.quotebot.domain.Blog;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlogAuctionTaskTest {
    @ParameterizedTest
    @MethodSource("providerModes")
    public void testPriceAndPublish(String mode, double expectedProposal, double averagePrice) {
        var blogAuctionTask = buildBlogAuctionTask(averagePrice);
        blogAuctionTask.priceAndPublish("blog", mode);
        assertEquals(expectedProposal, blogAuctionTask.proposal);
    }

    private static Stream<Arguments> providerModes() {
        return Stream.of(
                Arguments.of("UNKNOWN", 3.15, 1.0),
                Arguments.of("UNKNOWN", 6.28, 0.0),
                Arguments.of("SLOW", 6.3, 1.0),
                Arguments.of("SLOW", 6.28, 0.0),
                Arguments.of("MEDIUM", 12.6, 1.0),
                Arguments.of("MEDIUM", 6.28, 0.0),
                Arguments.of("FAST", 25.2, 1.0),
                Arguments.of("FAST", 6.28, 0.0),
                Arguments.of("ULTRAFAST", 40.949999999999996, 1.0),
                Arguments.of("ULTRAFAST", 6.28, 0.0)
        );
    }

    private BlogAuctionTask buildBlogAuctionTask(double averagePrice) {
        return new BlogAuctionTask() {
            @Override
            protected double averagePrice(Blog blog) {
                return averagePrice;
            }

            @Override
            protected void publish(double proposal) {
                this.proposal = proposal;
            }

            @Override
            protected long timeDiff(java.util.Date date) {
                return 1;
            }
        };
    }
}
