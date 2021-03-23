package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public ReviewPageObject clickToAddYourReviewButton() {
		waitForElementClickable(driver, ProductPageUI.ADD_YOUR_REVIEW_BUTTON);
		clickToElement(driver, ProductPageUI.ADD_YOUR_REVIEW_BUTTON);
		sleepInSecond(2);
		return PageGeneratorManager.getReviewPage(driver);
	}

}
