package com.qa.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	private Playwright playwright;
	private Browser browser;
	private BrowserContext browserContext;
	private Page page;
	private Properties prop;


	public Page initBrowser(Properties prop) {

		String browserName = prop.getProperty("browser").trim();
		System.out.println("browser name is : " + browserName);

		playwright = Playwright.create();

		switch (browserName.toLowerCase()) {
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		case "edge":
			browser = playwright.chromium().launch(new LaunchOptions().setChannel("msedge").setHeadless(false));
			break;	

		default:
			System.out.println("please pass the right browser name");
			break;
		}

		//browserContext = browser.newContext();
		browserContext=browser.newContext(new Browser.NewContextOptions()
		.setViewportSize(375, 667) 
		.setRecordVideoDir(Paths.get("videos"))
		.setRecordVideoSize(375, 667));
		page = browserContext.newPage();
		page.setDefaultTimeout(60000); 
		System.out.println("Step 1: Navigating to trajectormedical.com");
		page.navigate(prop.getProperty("url").trim());
		return page;

	}

	public Properties init_prop() {

		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}
	public void closeBrowser() {
		if (page != null) {
			page.close();
		}
		if (browserContext != null) {
			browserContext.close();
		}
		if (browser != null) {
			browser.close();
		}
		if (playwright != null) {
			playwright.close();
		}
	}

}
