package com.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Register_To_System;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import utilities.FakerConfig;

public class Login extends BaseTest {
	WebDriver driver;
	FakerConfig faker;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	String emailAddress, invalidEmailAddress, password, invalidPassword;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		
		faker = FakerConfig.getData();
		emailAddress = faker.getEmail();
		invalidEmailAddress = "automation@mail@gmail.com";
		password = faker.getPassword();
		invalidPassword = "12345";
		
		log.info("Precondition 01: Open Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Precondition 02: Click to Login link");
		loginPage = homePage.clickToLoginLink();
	}

	@Test
	public void Login_01_Login_With_Empty_Data() {
		log.info("Login_01_Login_With_Empty_Data - Step 01: Do not input to Email textbox");
		loginPage.inputToEmailTextbox("");
		
		log.info("Login_01_Login_With_Empty_Data - Step 02: Do not input to Password textbox");
		loginPage.inputToPasswordTextbox("");
		
		log.info("Login_01_Login_With_Empty_Data - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		
		log.info("Login_01_Login_With_Empty_Data - Step 04: Verify Empty Email Message Displayed");
		verifyTrue(loginPage.isEmptyEmailMessageDisplayed());
	}
	
	@Test
	public void Login_02_Login_With_Invalid_Email() {
		log.info("Login_02_Login_With_Invalid_Email - Step 01: Input invalid email to Email textbox with: " + invalidEmailAddress);
		loginPage.inputToEmailTextbox(invalidEmailAddress);
		
		log.info("Login_02_Login_With_Invalid_Email - Step 02: Input to Password textbox with: " + password);
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login_02_Login_With_Invalid_Email - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		
		log.info("Login_02_Login_With_Invalid_Email - Step 04: Verify Wrong Email Message Displayed");
		verifyTrue(loginPage.isWrongEmailMessageDisplayed());
	}
	
	@Test
	public void Login_03_Login_With_Not_Exist_Email() {
		log.info("Login_03_Login_With_Not_Exist_Email - Step 01: Input not exist email to Email textbox with: " + emailAddress);
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Login_03_Login_With_Not_Exist_Email - Step 02: Input to Password textbox with: " + password);
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Login_03_Login_With_Not_Exist_Email - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		
		log.info("Login_03_Login_With_Not_Exist_Email - Step 04: Verify No Customer Account Message Displayed");
		verifyTrue(loginPage.isNoCustomerAccountMessageDisplayed());
	}
	
	@Test
	public void Login_04_Login_With_Empty_Password() {
		log.info("Login_04_Login_With_Empty_Password - Step 01: Input to Email textbox with: " + Register_To_System.emailAddress);
		loginPage.inputToEmailTextbox(Register_To_System.emailAddress);
		
		log.info("Login_04_Login_With_Empty_Password - Step 02: Do not input to Password textbox");
		loginPage.inputToPasswordTextbox("");
		
		log.info("Login_04_Login_With_Empty_Password - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		
		log.info("Login_04_Login_With_Empty_Password - Step 04: Verify Empty Password Message Displayed");
		verifyTrue(loginPage.isInvalidPasswordMessageDisplayed());
	}
	
	@Test
	public void Login_05_Login_With_Invalid_Password() {
		log.info("Login_05_Login_With_Invalid_Password - Step 01: Input to Email textbox with: " + Register_To_System.emailAddress);
		loginPage.inputToEmailTextbox(Register_To_System.emailAddress);
		
		log.info("Login_05_Login_With_Invalid_Password - Step 02: Input invalid password to Password textbox with: " + invalidPassword);
		loginPage.inputToPasswordTextbox(invalidPassword);
		
		log.info("Login_05_Login_With_Invalid_Password - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		
		log.info("Login_05_Login_With_Invalid_Password - Step 04: Verify Invalid Password Message Displayed");
		verifyTrue(loginPage.isInvalidPasswordMessageDisplayed());
	}
	
	@Test
	public void Login_06_Login_With_Valid_Data() {
		log.info("Login_06_Login_With_Valid_Data - Step 01: Input valid email to Email textbox with: " + Register_To_System.emailAddress);
		loginPage.inputToEmailTextbox(Register_To_System.emailAddress);
		
		log.info("Login_06_Login_With_Valid_Data - Step 02: Input valid password to Password textbox with: " + Register_To_System.password);
		loginPage.inputToPasswordTextbox(Register_To_System.password);
		
		log.info("Login_06_Login_With_Valid_Data - Step 03: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login_06_Login_With_Valid_Data - Step 04: Verify My Account Link Displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
