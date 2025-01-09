package com.arolla.legacy.testing.thirdparty.quotebot;

import java.util.Random;

public class MarketStudyVendor {

	public double averagePrice(String blog) {
		if (System.getenv("license") == null) {
			System.out.println("Missing license !");
			throw new RuntimeException("");
		}
		return ((double) blog.hashCode() * (new Random()).nextDouble());
	}

}
