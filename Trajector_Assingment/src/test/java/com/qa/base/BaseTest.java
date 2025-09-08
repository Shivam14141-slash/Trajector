package com.qa.base;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.microsoft.playwright.Page;
import com.qa.factory.PlaywrightFactory;
import com.qa.pages.GetStartedPage;
import com.qa.pages.HomePage;

public class BaseTest {

	protected static Logger logger = LogManager.getLogger(BaseTest.class);
	
	PlaywrightFactory pf;
	Page page;
	protected Properties prop;

	protected HomePage homePage;
	protected GetStartedPage getstartedPage;

	@Parameters({ "browser" })
	@BeforeTest
	public void setup(String browserName) {
		setupLog4jFileLogging();
		
		logger.info("*****  Test  Started  *****");
		
		pf = new PlaywrightFactory();
		logger.info("PlaywrightFactory initialized");

		prop = pf.init_prop();
		logger.info("Properties loaded");

		if (browserName != null) {
			prop.setProperty("browser", browserName);
			logger.info("Browser set to: " + browserName);
		}

		page = pf.initBrowser(prop);
		logger.info("Browser initialized and go to: " + prop.getProperty("url"));
		homePage = new HomePage(page);
		logger.info("HomePage object created");
	}

	

	@AfterTest
	public void tearDown() {
		logger.info("**** Test  Completed ****");
		if (pf != null) {
			logger.info("***Closing browser***");
			pf.closeBrowser();
		}
	}


	private void setupLog4jFileLogging() {
		System.out.println("Log4j will write logs to test-logs.txt");
	}

}
