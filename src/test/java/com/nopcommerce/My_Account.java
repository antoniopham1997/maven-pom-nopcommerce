package com.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.ProductPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.ReviewPageObject;
import utilities.FakerConfig;

public class My_Account extends BaseTest {
	WebDriver driver;
	FakerConfig faker;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;
	ProductPageObject productPage;
	ReviewPageObject reviewPage;
	String newFirstName, newLastName, newEmailAddress, newCompanyName, newPassword, tc02FirstName, tc02LastName, tc02EmailAddress, tc02CompanyName, tc02City, tc02Address1, tc02Address2, tc02ZipPostalCode, tc02PhoneNumber, tc02FaxNumber; 
	String emailAddress, password, firstName, lastName, companyName, day, month, year;
	
	String newGender = "female";
	String newDay = "1";
	String newMonth = "January";
	String newYear = "1999";
	
	String tc02Country = "United States";
	String tc02StateProvince = "Alaska";
	
	String productName = "Apple MacBook Pro 13-inch";
	String reviewTitle = "Review title";
	String reviewText = "Review text";
	String ratingPoint = "5";
	
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
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		
		faker = FakerConfig.getData();
		newFirstName = faker.getFirstName();
		newLastName = faker.getLastName();
		newEmailAddress = faker.getEmail();
		newCompanyName = faker.getCompanyName();
		newPassword = faker.getPassword();
		tc02FirstName = faker.getFirstName();
		tc02LastName = faker.getLastName();
		tc02EmailAddress = faker.getEmail();
		tc02CompanyName = faker.getCompanyName();
		tc02City = faker.getCity();
		tc02Address1 = faker.getAddress();
		tc02Address2 = faker.getAddress();
		tc02ZipPostalCode = faker.getZipCode();
		tc02PhoneNumber = faker.getPhone();
		tc02FaxNumber = faker.getPhone();
		
		
		log.info("Precondition 01: Open Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("Precondition 02: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Precondition 03: Input valid email to Email textbox with: " + emailAddress);
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Precondition 04: Input valid password to Password textbox with: " + password);
		loginPage.inputToPasswordTextbox(password);
		
		log.info("Precondition 05: Click to Login button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Precondition 06: Verify My Account Link Displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("Precondition 07: Click to My Account Link");
		myAccountPage = homePage.clickToMyAccountLink();
	}

	@Test
	public void My_Account_01_Customer_Info() {
		log.info("My_Account_01_Customer_Info - Step 01: Update Gender to " + newGender);
		myAccountPage.clickToGenderByID(driver, "female");
		
		log.info("My_Account_01_Customer_Info - Step 02: Update Firstname to " + newFirstName);
		myAccountPage.inputToTextboxInCustomerInfoByID(driver, newFirstName, "FirstName");
		
		log.info("My_Account_01_Customer_Info - Step 03: Update Lastname to " + newLastName);
		myAccountPage.inputToTextboxInCustomerInfoByID(driver, newLastName, "LastName");
		
		log.info("My_Account_01_Customer_Info - Step 04: Update DOB Day to " + newDay);
		myAccountPage.selectDOBByName(driver, "Day", newDay);
		
		log.info("My_Account_01_Customer_Info - Step 05: Update DOB Month to " + newMonth);
		myAccountPage.selectDOBByName(driver, "Month", newMonth);
		
		log.info("My_Account_01_Customer_Info - Step 06: Update DOB Year to " + newYear);
		myAccountPage.selectDOBByName(driver, "Year", newYear);
		
		log.info("My_Account_01_Customer_Info - Step 07: Update Email to " + newEmailAddress);
		myAccountPage.inputToTextboxInCustomerInfoByID(driver, newEmailAddress, "Email");
		
		log.info("My_Account_01_Customer_Info - Step 08: Update Company name to " + newCompanyName);
		myAccountPage.inputToTextboxInCustomerInfoByID(driver, newCompanyName, "Company");
		
		log.info("My_Account_01_Customer_Info - Step 09: Click Save button");
		myAccountPage.clickToButtonInMyAccountByText(driver, "Save");
		
		log.info("My_Account_01_Customer_Info - Step 10: Verify new Gender");
		verifyTrue(myAccountPage.isGenderInMyAccountSelectedByID(driver, newGender));
		
		log.info("My_Account_01_Customer_Info - Step 11: Verify new Firstname");
		verifyEquals(myAccountPage.getValueOfTextboxInMyAccountByID(driver, "value", "FirstName"), newFirstName);
		
		log.info("My_Account_01_Customer_Info - Step 12: Verify new Lastname");
		verifyEquals(myAccountPage.getValueOfTextboxInMyAccountByID(driver, "value", "LastName"), newLastName);
		
		log.info("My_Account_01_Customer_Info - Step 13: Verify new DOB Day");
		verifyEquals(myAccountPage.getSelectedItemInDropdownInMyAccountByName(driver, "Day"), newDay);
		
		log.info("My_Account_01_Customer_Info - Step 14: Verify new DOB Month");
		verifyEquals(myAccountPage.getSelectedItemInDropdownInMyAccountByName(driver, "Month"), newMonth);
		
		log.info("My_Account_01_Customer_Info - Step 15: Verify new DOB Year");
		verifyEquals(myAccountPage.getSelectedItemInDropdownInMyAccountByName(driver, "Year"), newYear);
		
		log.info("My_Account_01_Customer_Info - Step 16: Verify new Email");
		verifyEquals(myAccountPage.getValueOfTextboxInMyAccountByID(driver, "value", "Email"), newEmailAddress);
		
		log.info("My_Account_01_Customer_Info - Step 17: Verify new Company name");
		verifyEquals(myAccountPage.getValueOfTextboxInMyAccountByID(driver, "value", "Company"), newCompanyName);
	}
	
	@Test
	public void My_Account_02_Addresses() {
		log.info("My_Account_02_Addresses - Step 01: Click to Addresses link");
		myAccountPage.clickToLinkInMyAccountByText(driver, "Addresses");
		
		log.info("My_Account_02_Addresses - Step 02: Click to Add new button");
		myAccountPage.clickToButtonInMyAccountByText(driver, "Add new");
		
		log.info("My_Account_02_Addresses - Step 03: Input to Firstname with: " + tc02FirstName);
		myAccountPage.inputToTextboxInAddressesByID(driver, tc02FirstName, "FirstName");
		
		log.info("My_Account_02_Addresses - Step 04: Input to Lastname with: " + tc02LastName);
		myAccountPage.inputToTextboxInAddressesByID(driver, tc02LastName, "LastName");
		
		log.info("My_Account_02_Addresses - Step 05: Input to Email with: " + tc02EmailAddress);
		myAccountPage.inputToTextboxInAddressesByID(driver, tc02EmailAddress, "Email");
		
		log.info("My_Account_02_Addresses - Step 06: Input to Company with: " + tc02CompanyName);
		myAccountPage.inputToTextboxInAddressesByID(driver, tc02CompanyName, "Company");
		
		log.info("My_Account_02_Addresses - Step 07: Select Country with: " + tc02Country);
		myAccountPage.selectDropdownInAddressesByID(driver, tc02Country, "Country");
		
		log.info("My_Account_02_Addresses - Step 08: Select State/ province with: " + tc02StateProvince);
		myAccountPage.selectDropdownInAddressesByID(driver, tc02StateProvince, "StateProvince");
		
		log.info("My_Account_02_Addresses - Step 09: Input to City with: " + tc02City);
		myAccountPage.inputToTextboxInAddressesByID(driver, tc02City, "City");
		
		log.info("My_Account_02_Addresses - Step 10: Input to Address 1 with: " + tc02Address1);
		myAccountPage.inputToTextboxInAddressesByID(driver, tc02Address1, "Address1");
		
		log.info("My_Account_02_Addresses - Step 11: Input to Address 2 with: " + tc02Address2);
		myAccountPage.inputToTextboxInAddressesByID(driver, tc02Address2, "Address2");
		
		log.info("My_Account_02_Addresses - Step 12: Input to Zip/ postal code with: " + tc02ZipPostalCode);
		myAccountPage.inputToTextboxInAddressesByID(driver, tc02ZipPostalCode, "ZipPostalCode");
		
		log.info("My_Account_02_Addresses - Step 13: Input to Phone number with: " + tc02PhoneNumber);
		myAccountPage.inputToTextboxInAddressesByID(driver, tc02PhoneNumber, "PhoneNumber");
		
		log.info("My_Account_02_Addresses - Step 14: Input to Fax number with: " + tc02FaxNumber);
		myAccountPage.inputToTextboxInAddressesByID(driver, tc02FaxNumber, "FaxNumber");
		
		log.info("My_Account_02_Addresses - Step 15: Click to Save button");
		myAccountPage.clickToButtonInMyAccountByText(driver, "Save");
		
		log.info("My_Account_02_Addresses - Step 16: Verify Fullname");
		verifyEquals(myAccountPage.getElementTextInAddressesByClass(driver, "name"), tc02FirstName + " " + tc02LastName);
		
		log.info("My_Account_02_Addresses - Step 18: Verify Email");
		verifyEquals(myAccountPage.getElementTextInAddressesByClass(driver, "email"), "Email: " + tc02EmailAddress);
		
		log.info("My_Account_02_Addresses - Step 19: Verify Company");
		verifyEquals(myAccountPage.getElementTextInAddressesByClass(driver, "company"), tc02CompanyName);
		
		log.info("My_Account_02_Addresses - Step 20: Verify Country");
		verifyEquals(myAccountPage.getElementTextInAddressesByClass(driver, "country"), tc02Country);
		
		log.info("My_Account_02_Addresses - Step 21: Verify City State/ province Zip");
		verifyEquals(myAccountPage.getElementTextInAddressesByClass(driver, "city-state-zip"), tc02City + ", " + tc02StateProvince + ", " + tc02ZipPostalCode);
		
		log.info("My_Account_02_Addresses - Step 22: Verify Address 1");
		verifyEquals(myAccountPage.getElementTextInAddressesByClass(driver, "address1"), tc02Address1);
		
		log.info("My_Account_02_Addresses - Step 23: Verify Address 2");
		verifyEquals(myAccountPage.getElementTextInAddressesByClass(driver, "address2"), tc02Address2);
		
		log.info("My_Account_02_Addresses - Step 24: Verify Phone number");
		verifyEquals(myAccountPage.getElementTextInAddressesByClass(driver, "phone"), "Phone number: " + tc02PhoneNumber);
		
		log.info("My_Account_02_Addresses - Step 25: Verify Fax number");
		verifyEquals(myAccountPage.getElementTextInAddressesByClass(driver, "fax"), "Fax number: " + tc02FaxNumber);
	}
	
	@Test
	public void My_Account_03_Change_Password() {
		log.info("My_Account_03_Change_Password - Step 01: Click to Change Password link");
		myAccountPage.clickToLinkInMyAccountByText(driver, "Change password");
		
		log.info("My_Account_03_Change_Password - Step 02: Input to Old Password with: " + password);
		myAccountPage.inputToTextboxInChangePasswordByID(driver, password, "OldPassword");
		
		log.info("My_Account_03_Change_Password - Step 03: Input to New Password with: " + newPassword);
		myAccountPage.inputToTextboxInChangePasswordByID(driver, newPassword, "NewPassword");
		
		log.info("My_Account_03_Change_Password - Step 04: Input to Confirm New Password with: " + newPassword);
		myAccountPage.inputToTextboxInChangePasswordByID(driver, newPassword, "ConfirmNewPassword");
		
		log.info("My_Account_03_Change_Password - Step 05: Click to Change Password button");
		myAccountPage.clickToButtonInMyAccountByText(driver, "Change password");
		
		log.info("My_Account_03_Change_Password - Step 06: Verify Password was changed");
		verifyTrue(myAccountPage.isChangePasswordSuccessMessageDisplayed());
		
		log.info("My_Account_03_Change_Password - Step 07: Close Change Password Success Message");
		myAccountPage.closeChangePasswordSuccessMessage();
		
		log.info("My_Account_03_Change_Password - Step 08: Click to Log out link");
		homePage = myAccountPage.clickToLogoutLink();
		
		log.info("My_Account_03_Change_Password - Step 09: Click to Log in link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("My_Account_03_Change_Password - Step 10: Input to Email with: " + newEmailAddress);
		loginPage.inputToEmailTextbox(newEmailAddress);
		
		log.info("My_Account_03_Change_Password - Step 11: Input to Password with: " + password);
		loginPage.inputToPasswordTextbox(password);
		
		log.info("My_Account_03_Change_Password - Step 12: Click to Log in button");
		loginPage.clickToLoginButton();
		
		log.info("My_Account_03_Change_Password - Step 13: Verify Invalid Password Message Displayed");
		verifyTrue(loginPage.isInvalidPasswordMessageDisplayed());
		
		log.info("My_Account_03_Change_Password - Step 14: Input to Email with: " + newEmailAddress);
		loginPage.inputToEmailTextbox(newEmailAddress);
		
		log.info("My_Account_03_Change_Password - Step 15: Input to Password with: " + newPassword);
		loginPage.inputToPasswordTextbox(newPassword);
		
		log.info("My_Account_03_Change_Password - Step 16: Click to Log in button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("My_Account_03_Change_Password - Step 17: Verify My Account Link Displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void My_Account_04_My_Product_Reviews() {
		log.info("My_Account_04_My_Product_Reviews - Step 01: Click to Product name with: " + productName);
		productPage = homePage.clickToProductNameByText(driver, productName);
		
		log.info("My_Account_04_My_Product_Reviews - Step 02: Click to Add your review");
		reviewPage = productPage.clickToAddYourReviewButton();
		
		log.info("My_Account_04_My_Product_Reviews - Step 03: Input to Review title with: " + reviewTitle);
		reviewPage.inputToReviewTitleTextbox(reviewTitle);
		
		log.info("My_Account_04_My_Product_Reviews - Step 04: Input to Review text with: " + reviewText);
		reviewPage.inputToReviewTextTextarea(reviewText);
		
		log.info("My_Account_04_My_Product_Reviews - Step 05: Select rating with value: " + ratingPoint);
		reviewPage.selectRatingPointInProductReviewByValue(driver, ratingPoint);
		
		log.info("My_Account_04_My_Product_Reviews - Step 06: Click to Submit review");
		reviewPage.clickToSubmitReviewButton();
		
		log.info("My_Account_04_My_Product_Reviews - Step 07: Verify Product review success message displayed");
		verifyTrue(reviewPage.isProductReviewSuccessMessageDisplayed());
		
		log.info("My_Account_04_My_Product_Reviews - Step 08: Click to My Account link");
		myAccountPage = reviewPage.clickToMyAccountLink();
		
		log.info("My_Account_04_My_Product_Reviews - Step 09: Click to My product reviews link");
		myAccountPage.clickToLinkInMyAccountByText(driver, "My product reviews");	
		
		log.info("My_Account_04_My_Product_Reviews - Step 10: Verify Review title");
		verifyEquals(myAccountPage.getReviewTitleInProductReviewByProductName(driver, productName), reviewTitle);
		
		log.info("My_Account_04_My_Product_Reviews - Step 11: Verify Review text");
		verifyEquals(myAccountPage.getReviewTextInProductReviewByProductName(driver, productName), reviewText);
		
		log.info("My_Account_04_My_Product_Reviews - Step 12: Verify Rating");
		verifyEquals(myAccountPage.getRatingInProductReviewByProductName(driver, productName), "width: " + Integer.parseInt(ratingPoint)*20 + "%;");
	}

	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
