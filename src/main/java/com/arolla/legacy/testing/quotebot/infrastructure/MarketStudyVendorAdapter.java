package com.arolla.legacy.testing.quotebot.infrastructure;

import com.arolla.legacy.testing.quotebot.domain.Blog;
import com.arolla.legacy.testing.quotebot.domain.MarketDataRetriever;
import com.arolla.legacy.testing.thirdparty.quotebot.MarketStudyVendor;

public class MarketStudyVendorAdapter implements MarketDataRetriever {
    private final MarketStudyVendor marketStudyVendor;

    public MarketStudyVendorAdapter(MarketStudyVendor marketStudyVendor
    ) {
        this.marketStudyVendor = marketStudyVendor;
    }

    @Override
    public double averagePrice(Blog blog) {
        return marketStudyVendor.averagePrice(blog.name());
    }
}
