package com.qa.utils;

import java.util.List;
import java.util.Random;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;

public class TestDataGenerator {
    
    private static Faker faker = new Faker();
    public static String getDisabilityRadio() {
        return faker.options().option("Yes", "No");
    }
    
    public static String getVeteranRadio() {
        return faker.options().option("Yes", "No"); 
    }
    public static String getRadioButton() {
        return faker.options().option("Yes", "No"); 
    }
    
    public static String getFillName() {
        return "Test_" + faker.name().firstName();
    }
    
    public static String getFillLastName() {
        return "Test_" + faker.name().lastName();
    }
    
     public static void getAgeDropDown(Page page, String ageLocator) {
         List<String> options = page.locator(ageLocator + " option").allTextContents();
         if (options.size() > 1) {
             Random random = new Random();
             int randomIndex = random.nextInt(options.size() - 1) + 1;
             page.locator(ageLocator).selectOption(options.get(randomIndex));
         }
     }
    
    public static String getEmail() {
        return faker.internet().emailAddress();
    }
    
    public static void getStateDropDown(Page page, String stateLocator) {
        List<String> options = page.locator(stateLocator + " option").allTextContents();
        if (options.size() > 1) {
            Random random = new Random();
            int randomIndex = random.nextInt(options.size() - 1) + 1;
            page.locator(stateLocator).selectOption(options.get(randomIndex));
        }
    }
    
    public static String getZipCode() {
        return faker.number().digits(6);
    }
    
    public static String getPhoneNumber() {
        return faker.number().digits(10);
    }
    
    public static void getCountryPhoneCodeDropDown(Page page, String countryCodeLocator) {
    
            page.locator("[class=\"iti__selected-country\"]").click();
            int optionCount = page.locator(countryCodeLocator).count();
            if (optionCount > 1) {
                Random random = new Random();
                int randomIndex = random.nextInt(optionCount - 1) + 1; 
                page.locator(countryCodeLocator).nth(randomIndex).click();
            }
        
    }
    
}
