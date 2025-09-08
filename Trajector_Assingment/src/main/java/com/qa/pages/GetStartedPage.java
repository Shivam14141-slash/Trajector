package com.qa.pages;

import com.microsoft.playwright.Page;
import com.qa.utils.TestDataGenerator;

public class GetStartedPage {

	private Page page;

	private String formTitle = "//div[@data-id=\"340ccd6b\"]//h2";
	private String fillName = "[id=\"input_41_12\"]";
	private String fillLastName = "[id=\"input_41_13\"]";
	private String ageDropDown = "[id=\"input_41_30\"]";
	private String email = "[id=\"input_41_3\"]";
	private String stateDropDown = "[id=\"input_41_26_4\"]";
	private String zipCode = "[id=\"input_41_26_5\"]";
	private String phoneNumber = "[id=\"input_41_4_raw\"]";
	private String countryPhoneCodeDropDown = "//ul[@id=\"iti-0__country-listbox\"]//li";
	private String termsCheckboxOne = "[id=\"label_41_33_1\"]";
	private String termsCheckboxTwo = "[id=\"label_41_34_1\"]";
	private String vertranActiveDuty = "[id=\"input_41_18\"]";
	private String vertranRated = "[id=\"input_41_17\"]";


	public GetStartedPage(Page page) {
		this.page = page;
	}
	
	public String getPageTitle() {
		return page.title();
	}

	public String getStartedPageURL() {
		String url =  page.url();
		System.out.println("page url : " + url);
		return url;
	}

	public String getFormTitle() {
		page.locator(formTitle).scrollIntoViewIfNeeded();
		return page.locator(formTitle).textContent();
	}
	
	public void fillFormWithRandomData() {
		System.out.println("Filling form with random test data...");
		
		fillDisabilityRadio(TestDataGenerator.getDisabilityRadio());
		String veteranRadio = TestDataGenerator.getVeteranRadio();
		fillVeteranRadio(veteranRadio);
		if(veteranRadio.equals("Yes")) {
			String activeDuty=TestDataGenerator.getRadioButton();
			fillVeteranActiveDuty(activeDuty);
			if(activeDuty.equals("Yes")) {
				String vaDisabilty = TestDataGenerator.getRadioButton();
				fillActiveDutyDischarge(vaDisabilty);
			}
			String veteranRated = TestDataGenerator.getRadioButton();
			fillVeteranRated(veteranRated);
			if(veteranRated.equals("Yes")) {
				String vaDisabilty = TestDataGenerator.getRadioButton();
				fillVADisabilty(vaDisabilty);
				if(vaDisabilty.equals("Yes")) {
					String vaUnemployment = TestDataGenerator.getRadioButton();
					fillVAUnemployment(vaUnemployment);
					fillVADenialt(vaUnemployment);
					
				}
			}
		}
		
		fillName(TestDataGenerator.getFillName());

		fillLastName(TestDataGenerator.getFillLastName());
		
		TestDataGenerator.getAgeDropDown(page, ageDropDown);
		
		fillEmail(TestDataGenerator.getEmail());
		
		TestDataGenerator.getStateDropDown(page, stateDropDown);
	
		fillZipCode(TestDataGenerator.getZipCode());
		
		fillPhoneNumber(TestDataGenerator.getPhoneNumber());

		TestDataGenerator.getCountryPhoneCodeDropDown(page, countryPhoneCodeDropDown);

			checkTermsCheckboxOne();
			checkTermsCheckboxTwo();
	}
	
	private void fillDisabilityRadio(String value) {
		System.out.println("Filling disability radio: " + value);
		String disabilityRadio = "//div[@id=\"input_41_28\"]//label[text()=\"" + value + "\"]";
		page.locator(disabilityRadio).click();
	}

	private void fillVeteranRadio(String value) {
		System.out.println("Filling veteran radio: " + value);
		String veteranRadio = "//div[@id=\"input_41_15\"]//label[text()=\"" + value + "\"]";
		page.locator(veteranRadio).click();
	}
	private void fillVeteranActiveDuty(String value) {
		System.out.println("Filling veteran active duty: " + value);
		String vertranActiveDuty = "//div[@id=\"input_41_18\"]//label[text()=\"" + value + "\"]";
		page.locator(vertranActiveDuty).click();
	}
	private void fillActiveDutyDischarge(String value) {
		System.out.println("Filling active duty discharge: " + value);
		String vertranActiveDischarge = "//div[@id=\"input_41_31\"]//label[text()=\"" + value + "\"]";
		page.locator(vertranActiveDischarge).click();
	}
	private void fillVADisabilty(String value) {
		System.out.println("Filling VA disability: " + value);
		String vertranVADisabilty = "//div[@id=\"input_41_16\"]//label[text()=\"" + value + "\"]";
		page.locator(vertranVADisabilty).click();
	}
	private void fillVAUnemployment(String value) {
		System.out.println("Filling VA disability: " + value);
		String vertranVADisabilty = "//div[@id=\"input_41_19\"]//label[text()=\"" + value + "\"]";
		page.locator(vertranVADisabilty).click();
	}
	private void fillVADenialt(String value) {
		System.out.println("Filling VA disability: " + value);
		String vertranVADisabilty = "//div[@id=\"input_41_29\"]//label[text()=\"" + value + "\"]";
		page.locator(vertranVADisabilty).click();
	}
	private void fillVeteranRated(String value) {
		System.out.println("Filling veteran rated: " + value);
		String vertranRated = "//div[@id=\"input_41_17\"]//label[text()=\"" + value + "\"]";
		page.locator(vertranRated).click();
	}
	private void fillName(String name) {
		System.out.println("Filling name: " + name);
		page.locator(fillName).fill(name);
	}

	private void fillLastName(String lastName) {
		System.out.println("Filling last name: " + lastName);
		page.locator(fillLastName).fill(lastName);
	}

	private void fillEmail(String email) {
		System.out.println("Filling email: " + email);
		page.locator(this.email).fill(email);
	}
	
	private void fillZipCode(String zipCode) {
		System.out.println("Filling zip code: " + zipCode);
		page.locator(this.zipCode).fill(zipCode);
	}
	
	private void fillPhoneNumber(String phoneNumber) {
		System.out.println("Filling phone number: " + phoneNumber);
		page.locator(this.phoneNumber).fill(phoneNumber);
	}
	
	private void checkTermsCheckboxOne() {
		System.out.println("Checking terms checkbox one");
		page.locator(termsCheckboxOne).click();
	}
	private void checkTermsCheckboxTwo() {
		System.out.println("Checking terms checkbox two");
		page.locator(termsCheckboxTwo).click();
	}
	
}
