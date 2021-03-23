package com.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Register_To_System;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import utilities.FakerConfig;

public class Register extends BaseTest{
	WebDriver driver;
	FakerConfig faker;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	String firstName, lastName, password, invalidPassword, invalidConfirmPassword, emailAddress, invalidEmailAddress;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		
		faker = FakerConfig.getData();
		
		firstName = faker.getFirstName();
		lastName = faker.getLastName();
		password = faker.getPassword();
		invalidPassword = "12345";
		invalidConfirmPassword = faker.getPassword();
		emailAddress = faker.getEmail();
		invalidEmailAddress = "auto@mail@mail.com";
		
		log.info("Precondition 01: Open Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Precondition 02: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
	}
	
	
	@Test
	public void Register_01_Register_With_Empty_Data() {
		log.info("Register_01_Register_With_Empty_Data - Step 01: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_01_Register_With_Empty_Data - Step 02: Verify First Name Error Message Displayed");
		verifyTrue(registerPage.isFirstNameErrorMessageDisplayed());
		
		log.info("Register_01_Register_With_Empty_Data - Step 03: Verify Last Name Error Message Displayed");
		verifyTrue(registerPage.isLastNameErrorMessageDisplayed());
		
		log.info("Register_01_Register_With_Empty_Data - Step 04: Verify Email Error Message Displayed");
		verifyTrue(registerPage.isEmailErrorMessageDisplayed());
		
		log.info("Register_01_Register_With_Empty_Data - Step 05: Verify Password Error Message Displayed");
		verifyTrue(registerPage.isPasswordErrorMessageDisplayed());
		
		log.info("Register_01_Register_With_Empty_Data - Step 06: Verify Confirm Password Error Message Displayed");
		verifyTrue(registerPage.isConfirmPasswordErrorMessageDisplayed());
	}
	@Test
	public void Register_02_Register_With_Invalid_Email() {
		log.info("Register_02_Register_With_Invalid_Email - Step 01: Input to Firstname with: " + firstName);
		registerPage.inputToTextboxInRegisterPageByID(driver, "FirstName", firstName);
		
		log.info("Register_02_Register_With_Invalid_Email - Step 02: Input to Lastname with: " + lastName);
		registerPage.inputToTextboxInRegisterPageByID(driver, "LastName", lastName);
		
		log.info("Register_02_Register_With_Invalid_Email - Step 03: Input to Email with: " + invalidEmailAddress);
		registerPage.inputToTextboxInRegisterPageByID(driver, "Email", invalidEmailAddress);
		
		log.info("Register_02_Register_With_Invalid_Email - Step 04: Input to Password with: " + password);
		registerPage.inputToTextboxInRegisterPageByID(driver, "Password", password);
		
		log.info("Register_02_Register_With_Invalid_Email - Step 05: Input to Confirm Password with: " + password);
		registerPage.inputToTextboxInRegisterPageByID(driver, "ConfirmPassword", password);
		
		log.info("Register_02_Register_With_Invalid_Email - Step 06: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_02_Register_With_Invalid_Email - Step 07: Verify Invalid Email Message Displayed");
		verifyTrue(registerPage.isInvalidEmailErrorMessageDisplayed());
	}
	@Test
	public void Register_03_Register_With_Existed_Email() {
		log.info("Register_03_Register_With_Existed_Email - Step 01: Input to Firstname with: " + firstName);
		registerPage.inputToTextboxInRegisterPageByID(driver, "FirstName", firstName);
		
		log.info("Register_03_Register_With_Existed_Email - Step 02: Input to Lastname with: " + lastName);
		registerPage.inputToTextboxInRegisterPageByID(driver, "LastName", lastName);
		
		log.info("Register_03_Register_With_Existed_Email - Step 03: Input to Email with: " + Register_To_System.emailAddress);
		registerPage.inputToTextboxInRegisterPageByID(driver, "Email", Register_To_System.emailAddress);
		
		log.info("Register_03_Register_With_Existed_Email - Step 04: Input to Password with: " + password);
		registerPage.inputToTextboxInRegisterPageByID(driver, "Password", password);
		
		log.info("Register_03_Register_With_Existed_Email - Step 05: Input to Confirm Password with: " + password);
		registerPage.inputToTextboxInRegisterPageByID(driver, "ConfirmPassword", password);
		
		log.info("Register_03_Register_With_Existed_Email - Step 06: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_03_Register_With_Existed_Email - Step 07: Verify Already Exists Email Message Displayed");
		verifyTrue(registerPage.isAlreadyExistsEmailMessageDisplayed());
	}
	@Test
	public void Register_04_Register_With_Invalid_Password() {
		log.info("Register_04_Register_With_Invalid_Password - Step 01: Input to Firstname with: " + firstName);
		registerPage.inputToTextboxInRegisterPageByID(driver, "FirstName", firstName);
		
		log.info("Register_04_Register_With_Invalid_Password - Step 02: Input to Lastname with: " + lastName);
		registerPage.inputToTextboxInRegisterPageByID(driver, "LastName", lastName);
		
		log.info("Register_04_Register_With_Invalid_Password - Step 03: Input to Email with: " + emailAddress);
		registerPage.inputToTextboxInRegisterPageByID(driver, "Email", emailAddress);
		
		log.info("Register_04_Register_With_Invalid_Password - Step 04: Input to Password with: " + invalidPassword);
		registerPage.inputToTextboxInRegisterPageByID(driver, "Password", invalidPassword);
		
		log.info("Register_04_Register_With_Invalid_Password - Step 05: Input to Confirm Password with: " + invalidPassword);
		registerPage.inputToTextboxInRegisterPageByID(driver, "ConfirmPassword", invalidPassword);
		
		log.info("Register_04_Register_With_Invalid_Password - Step 06: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_04_Register_With_Invalid_Password - Step 07: Verify Invalid Password Message Displayed");
		verifyTrue(registerPage.isInvalidPasswordErrorMessageDisplayed());
	}
	@Test
	public void Register_05_Register_With_Invalid_Confirm_Password() {
		log.info("Register_05_Register_With_Invalid_Confirm_Password - Step 01: Input to Firstname with: " + firstName);
		registerPage.inputToTextboxInRegisterPageByID(driver, "FirstName", firstName);
		
		log.info("Register_05_Register_With_Invalid_Confirm_Password - Step 02: Input to Lastname with: " + lastName);
		registerPage.inputToTextboxInRegisterPageByID(driver, "LastName", lastName);
		
		log.info("Register_05_Register_With_Invalid_Confirm_Password - Step 03: Input to Email with: " + emailAddress);
		registerPage.inputToTextboxInRegisterPageByID(driver, "Email", emailAddress);
		
		log.info("Register_05_Register_With_Invalid_Confirm_Password - Step 04: Input to Password with: " + password);
		registerPage.inputToTextboxInRegisterPageByID(driver, "Password", password);
		
		log.info("Register_05_Register_With_Invalid_Confirm_Password - Step 05: Input to Confirm Password with: " + invalidConfirmPassword);
		registerPage.inputToTextboxInRegisterPageByID(driver, "ConfirmPassword", invalidConfirmPassword);
		
		log.info("Register_05_Register_With_Invalid_Confirm_Password - Step 06: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_05_Register_With_Invalid_Confirm_Password - Step 07: Verify Invalid Confirm Password Message Displayed");
		verifyTrue(registerPage.isInvalidConfirmPasswordErrorMessageDisplayed());
	}
	@Test
	public void Register_06_Register_With_Valid_Data() {
		log.info("Register_06_Register_With_Valid_Data - Step 01: Input to Firstname with: " + firstName);
		registerPage.inputToTextboxInRegisterPageByID(driver, "FirstName", firstName);
		
		log.info("Register_06_Register_With_Valid_Data - Step 02: Input to Lastname with: " + lastName);
		registerPage.inputToTextboxInRegisterPageByID(driver, "LastName", lastName);
		
		log.info("Register_06_Register_With_Valid_Data - Step 03: Input to Email with: " + emailAddress);
		registerPage.inputToTextboxInRegisterPageByID(driver, "Email", emailAddress);
		
		log.info("Register_06_Register_With_Valid_Data - Step 04: Input to Password with: " + password);
		registerPage.inputToTextboxInRegisterPageByID(driver, "Password", password);
		
		log.info("Register_06_Register_With_Valid_Data - Step 05: Input to Confirm Password with: " + password);
		registerPage.inputToTextboxInRegisterPageByID(driver, "ConfirmPassword", password);
		
		log.info("Register_06_Register_With_Valid_Data - Step 06: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_06_Register_With_Valid_Data - Step 07: Verify Register Success Message Displayed");
		verifyTrue(registerPage.isRegisterSuccessMessageDisplayed());
	}
	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
