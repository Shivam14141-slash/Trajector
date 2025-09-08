package com.qa.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.constants.AppConstants;
import com.qa.pages.GetStartedPage;

public class TrajectorSmokeTest extends BaseTest {
   
	private static Logger logger = LogManager.getLogger(TrajectorSmokeTest.class);
	GetStartedPage getStartedPage;

	@Test(description = "Trajector Medical Home Page Test")
	public void trajectorMedicalHomePageTest() {
		logger.info("Step 1: Verifying Home Page");
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
		logger.info("Home page title verified: " + actualTitle);
		
		String actualURL = homePage.getHomePageURL();
		Assert.assertEquals(actualURL, prop.getProperty("url"));
		logger.info("Home page URL verified: " + actualURL);
		
		Assert.assertTrue(homePage.reviewSection());
		logger.info("Review section verified");
		
		logger.info("Step 2: Clicking Get Started button");
		getStartedPage = homePage.clickGetStarted();
		logger.info("Successfully navigated to Get Started page");
	}
	
	@Test(description = "Trajector Medical Get Started Page Test", dependsOnMethods = "trajectorMedicalHomePageTest", invocationCount = 1)
	public void trajectorMedicalGetStartedPageTest() throws InterruptedException {
		logger.info("Step 3: Verifying Get Started Page");
		Assert.assertEquals(getStartedPage.getPageTitle(), AppConstants.GET_STARTED_PAGE_TITLE);
		logger.info("Get Started page title verified");
		
		Assert.assertEquals(getStartedPage.getStartedPageURL(), prop.getProperty("getstartedurl"));
		logger.info("Get Started page URL verified");
		
		Assert.assertEquals(getStartedPage.getFormTitle(), prop.getProperty("formtitle"), "Form title should match exactly");
		logger.info("Form title verified");
		
		logger.info("Step 4: Filling form with random test data");
		getStartedPage.fillFormWithRandomData();
		logger.info("Form filled successfully with random data");
		Thread.sleep(10000); 
	}
}