package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public boolean isFirstNameErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_EMPTY_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.FIRST_NAME_EMPTY_ERROR_MESSAGE);
	}

	public boolean isLastNameErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_EMPTY_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.LAST_NAME_EMPTY_ERROR_MESSAGE);
	}

	public boolean isEmailErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_EMPTY_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_EMPTY_ERROR_MESSAGE);
	}

	public boolean isPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_EMPTY_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.PASSWORD_EMPTY_ERROR_MESSAGE);
	}

	public boolean isConfirmPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_EMPTY_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.CONFIRM_PASSWORD_EMPTY_ERROR_MESSAGE);
	}

	public boolean isInvalidEmailErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_INVALID_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.EMAIL_INVALID_ERROR_MESSAGE);
	}

	public boolean isAlreadyExistsEmailMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.ALREADY_EXISTS_EMAIL_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.ALREADY_EXISTS_EMAIL_ERROR_MESSAGE);
	}

	public boolean isInvalidPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
	}

	public boolean isInvalidConfirmPasswordErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.INVALID_CONFIRM_PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.INVALID_CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public boolean isRegisterSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

}
