package com.qa.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;

	private String getStarted = "//span[text()=\"Get Started\"]";
	private String reviewSection = "//h3[text()=\"TRAJECTOR MEDICAL REVIEWS\"]";

	public HomePage(Page page) {
		this.page = page;
	}

	public String getHomePageTitle() {
		String title =  page.title();
		System.out.println("page title: " + title);
		return title;
	}

	public String getHomePageURL() {
		String url =  page.url();
		System.out.println("page url : " + url);
		return url;
	}
	public boolean reviewSection() {
		boolean review=page.locator(reviewSection).isVisible();
		System.out.println("Review section is visible" + review);
		return review;
	}
	public GetStartedPage clickGetStarted() {
		System.out.println("Clicking on Get Started button...");
		page.locator(getStarted).first().click();
		System.out.println("Navigated to Get Started page");
		return new GetStartedPage(page);
	}
	
}
