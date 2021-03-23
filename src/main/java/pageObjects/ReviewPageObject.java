package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.ReviewPageUI;

public class ReviewPageObject extends BasePage {
	WebDriver driver;

	public ReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToReviewTitleTextbox(String reviewTitleValue) {
		waitForElementVisible(driver, ReviewPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, ReviewPageUI.REVIEW_TITLE_TEXTBOX, reviewTitleValue);
	}

	public void inputToReviewTextTextarea(String reviewTextValue) {
		waitForElementVisible(driver, ReviewPageUI.REVIEW_TEXT_TEXTAREA);
		sendkeyToElement(driver, ReviewPageUI.REVIEW_TEXT_TEXTAREA, reviewTextValue);
	}

	public void clickToSubmitReviewButton() {
		waitForElementClickable(driver, ReviewPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, ReviewPageUI.SUBMIT_REVIEW_BUTTON);
		sleepInSecond(1);
	}

	public boolean isProductReviewSuccessMessageDisplayed() {
		waitForElementVisible(driver, ReviewPageUI.PRODUCT_REVIEW_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, ReviewPageUI.PRODUCT_REVIEW_SUCCESS_MESSAGE);
	}

	public MyAccountPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, ReviewPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, ReviewPageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPage(driver);
	}

}
