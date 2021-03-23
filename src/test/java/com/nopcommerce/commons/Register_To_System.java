package com.nopcommerce.commons;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import utilities.FakerConfig;


public class Register_To_System extends BaseTest{
	WebDriver driver;	
	FakerConfig faker;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	public static String emailAddress, password;
	String firstName, lastName, companyName, day, month, year;
	
	@Parameters({"browser", "url"})
	@BeforeTest
	public void beforeTest(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		
		faker = FakerConfig.getData();
		
		firstName = faker.getFirstName();
		lastName = faker.getLastName();
		emailAddress = faker.getEmail();
		companyName = faker.getCompanyName();
		password = faker.getPassword();
		day = "24";
		month = "August";
		year = "1990";
		
		log.info("Register_To_System - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Register_To_System - Step 02: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register_To_System - Step 03: Select gender male");
		registerPage.clickToGenderByID(driver, "male");
				
		log.info("Register_To_System - Step 04: Input to Firstname with: " + firstName);
		registerPage.inputToTextboxInRegisterPageByID(driver, "FirstName", firstName);
		
		log.info("Register_To_System - Step 05: Input to Lastname with: " + lastName);
		registerPage.inputToTextboxInRegisterPageByID(driver, "LastName", lastName);
		
		log.info("Register_To_System - Step 06: Select day: " + day);
		registerPage.selectDOBByName(driver, "Day", day);
		
		log.info("Register_To_System - Step 07: Select month: " + month);
		registerPage.selectDOBByName(driver, "Month", month);
		
		log.info("Register_To_System - Step 08: Select year: " + year);
		registerPage.selectDOBByName(driver, "Year", year);
		
		log.info("Register_To_System - Step 09: Input to Email with: " + emailAddress);
		registerPage.inputToTextboxInRegisterPageByID(driver, "Email", emailAddress);
		
		log.info("Register_To_System - Step 10: Input to Company name with: " + companyName);
		registerPage.inputToTextboxInRegisterPageByID(driver, "Company", companyName);
		
		log.info("Register_To_System - Step 11: Input to Password with: " + password);
		registerPage.inputToTextboxInRegisterPageByID(driver, "Password", password);
		
		log.info("Register_To_System - Step 12: Input to Confirm Password with: " + password);
		registerPage.inputToTextboxInRegisterPageByID(driver, "ConfirmPassword", password);
		
		log.info("Register_To_System - Step 13: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_To_System - Step 14: Verify Register Success Message Displayed");
		verifyTrue(registerPage.isRegisterSuccessMessageDisplayed());
		driver.quit();
	}

}
