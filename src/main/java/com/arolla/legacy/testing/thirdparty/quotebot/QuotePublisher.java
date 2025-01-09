package com.arolla.legacy.testing.thirdparty.quotebot;

public class QuotePublisher {

	public static final QuotePublisher INSTANCE = new QuotePublisher();

	public void publish(double todayPrice) {
		System.out.println("You've pushed a dummy auction to a real ads platform, the business is upset!");
	}
}
