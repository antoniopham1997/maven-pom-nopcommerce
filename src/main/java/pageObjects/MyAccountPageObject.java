package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isChangePasswordSuccessMessageDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, MyAccountPageUI.CHANGE_PASSWORD_SUCCESS_MESSAGE);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, MyAccountPageUI.LOG_OUT_LINK);
		clickToElement(driver, MyAccountPageUI.LOG_OUT_LINK);
		sleepInSecond(1);
		return PageGeneratorManager.getHomePage(driver);
	}

	public void closeChangePasswordSuccessMessage() {
		waitForElementClickable(driver, MyAccountPageUI.CLOSE_CHANGE_PASSWORD_MESSAGE_BUTTON);
		clickToElement(driver, MyAccountPageUI.CLOSE_CHANGE_PASSWORD_MESSAGE_BUTTON);
		sleepInSecond(1);
	}

}
