package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		sleepInSecond(1);
		return PageGeneratorManager.getHomePage(driver);
	}

	public boolean isEmptyEmailMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_EMAIL_MESSAGE);
		return isElementDisplayed(driver, LoginPageUI.EMPTY_EMAIL_MESSAGE);
	}

	public boolean isWrongEmailMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.WRONG_EMAIL_MESSAGE);
		return isElementDisplayed(driver, LoginPageUI.WRONG_EMAIL_MESSAGE);
	}

	public boolean isNoCustomerAccountMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.NO_CUSTOMER_ACCOUNT_MESSAGE);
		return isElementDisplayed(driver, LoginPageUI.NO_CUSTOMER_ACCOUNT_MESSAGE);
	}

	public boolean isInvalidPasswordMessageDisplayed() {
		waitForElementVisible(driver, LoginPageUI.INVALID_PASSWORD_MESSAGE);
		return isElementDisplayed(driver, LoginPageUI.INVALID_PASSWORD_MESSAGE);
	}
	
}
