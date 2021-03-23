package commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.PageGeneratorManager;
import pageObjects.ProductPageObject;
import pageUIs.HomePageUI;
import pageUIs.MyAccountPageUI;
import pageUIs.RegisterPageUI;
import pageUIs.ReviewPageUI;

public class BasePage {
	
	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			String currentWindowTitle = driver.getTitle();
			if (currentWindowTitle.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	
	public String getDynamicLocator(String locator, String... values) {
		return String.format(locator, (Object[]) values);
	}

	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String... values) {
		getWebElement(driver, getDynamicLocator(locator, values)).click();
	}

	private void clickToElement(WebElement element) {
		element.click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = getWebElement(driver, locator);
		element.clear();
		element.sendKeys(value);
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value, String... values) {
		WebElement element = getWebElement(driver, getDynamicLocator(locator, values));
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String valueItem) {
		Select select = new Select(getWebElement(driver, locator));
		select.selectByVisibleText(valueItem);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String valueItem, String... values) {
		Select select = new Select(getWebElement(driver, getDynamicLocator(locator, values)));
		select.selectByVisibleText(valueItem);
	}

	public String getSelectedItemInDropdown(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public String getSelectedItemInDropdown(WebDriver driver, String locator, String... values) {
		Select select = new Select(getWebElement(driver, getDynamicLocator(locator, values)));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.isMultiple();
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		clickToElement(driver, parentLocator);
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		List<WebElement> allItems = getListWebElement(driver, childItemLocator);

		for (WebElement item : allItems) {
			if (item.getText().equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				clickToElement(item);
				sleepInSecond(1);
				break;
			}
		}
	}

	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText().trim();
	}
	
	public String getElementText(WebDriver driver, String locator, String... values) {
		return getWebElement(driver, getDynamicLocator(locator, values)).getText().trim();
	}
	
	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return getWebElement(driver, locator).getAttribute(attributeName);
	}
	
	public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... values) {
		return getWebElement(driver, getDynamicLocator(locator, values)).getAttribute(attributeName);
	}

	public int getElementNumber(WebDriver driver, String locator) {
		return getListWebElement(driver, locator).size();
	}
	
	public int getElementNumber(WebDriver driver, String locator, String... values) {
		return getListWebElement(driver, getDynamicLocator(locator, values)).size();
	}

	public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void checkToCheckboxOrRadio(WebDriver driver, String locator, String... values) {
		WebElement element = getWebElement(driver, getDynamicLocator(locator, values));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		return getWebElement(driver, getDynamicLocator(locator, values)).isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator, String... values) {
		return getWebElement(driver, getDynamicLocator(locator, values)).isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}

	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver, locator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locator)).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locator), key).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... values) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicLocator(locator, values)), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", getWebElement(driver, locator), "style","border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", getWebElement(driver, locator), "style",getWebElement(driver, locator).getAttribute("style"));
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}
	
	public void clickToElementByJS(WebDriver driver, String locator, String... values) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, getDynamicLocator(locator, values)));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",getWebElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}
	
	public void waitForListElementVisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overideImplicitWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
		overideImplicitWait(driver, longTimeout);
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		overideImplicitWait(driver, shortTimeout);
		elements = getListWebElement(driver, locator);
		overideImplicitWait(driver, longTimeout);
		
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	public void overideImplicitWait(WebDriver driver, long timeInSecond) {
		driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator, String... values) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, values))));
	}
	
	public String getDirectorySlash(String folderName) {
		String separator = System.getProperty("file.separator");
		return separator + folderName + separator;
	}
	
	public void clickToGenderByID(WebDriver driver, String genderValue) {
		waitForElementClickable(driver, RegisterPageUI.DYNAMIC_GENDER_BUTTON_BY_ID, genderValue);
		clickToElement(driver, RegisterPageUI.DYNAMIC_GENDER_BUTTON_BY_ID, genderValue);
	}
	
	public void selectDOBByName(WebDriver driver, String dobName, String valueItem) {
		waitForElementClickable(driver, RegisterPageUI.DYNAMIC_DOB_DROPDOWN_BY_NAME, dobName);
		selectItemInDropdown(driver, RegisterPageUI.DYNAMIC_DOB_DROPDOWN_BY_NAME, valueItem, dobName);
	}
	
	public void inputToTextboxInRegisterPageByID(WebDriver driver, String textboxValue, String value) {
		waitForElementVisible(driver, RegisterPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxValue);
		sendkeyToElement(driver, RegisterPageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxValue);
	}
	
	public void clickToLinkInMyAccountByText(WebDriver driver, String... values) {
		waitForElementClickable(driver, MyAccountPageUI.DYNAMIC_LINK_BY_TEXT, values);
		clickToElement(driver, MyAccountPageUI.DYNAMIC_LINK_BY_TEXT, values);
		sleepInSecond(2);
	}
	
	public void inputToTextboxInAddressesByID(WebDriver driver, String value, String... values) {
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_TEXTBOX_IN_ADDRESSES_BY_ID, values);
		sendkeyToElement(driver, MyAccountPageUI.DYNAMIC_TEXTBOX_IN_ADDRESSES_BY_ID, value, values);
	}
	
	public void selectDropdownInAddressesByID(WebDriver driver, String valueItem, String... values) {
		waitForElementClickable(driver, MyAccountPageUI.DYNAMIC_DROPDOWN_IN_ADDRESSES_BY_ID, values);
		selectItemInDropdown(driver, MyAccountPageUI.DYNAMIC_DROPDOWN_IN_ADDRESSES_BY_ID, valueItem, values);
	}
	
	public String getElementTextInAddressesByClass(WebDriver driver, String... values) {
		return getWebElement(driver, getDynamicLocator(MyAccountPageUI.DYNAMIC_ADDRESSES_INFORMATION_BY_CLASS, values)).getText().trim();
	}
	
	public boolean isGenderInMyAccountSelectedByID(WebDriver driver, String... genderValue) {
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_GENDER_BY_ID, genderValue);
		return isElementSelected(driver, MyAccountPageUI.DYNAMIC_GENDER_BY_ID, genderValue);
	}
	
	public String getValueOfTextboxInMyAccountByID(WebDriver driver, String attributeName, String... values) {
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_TEXTBOX_IN_CUSTOMER_INFO_BY_ID, values);
		return getElementAttribute(driver, MyAccountPageUI.DYNAMIC_TEXTBOX_IN_CUSTOMER_INFO_BY_ID, attributeName, values);
	}
	
	public String getSelectedItemInDropdownInMyAccountByName(WebDriver driver, String... values) {
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_DOB_DROPDOWN_BY_NAME, values);
		return getSelectedItemInDropdown(driver, MyAccountPageUI.DYNAMIC_DOB_DROPDOWN_BY_NAME, values);
	}
	
	public void inputToTextboxInChangePasswordByID(WebDriver driver, String value, String... values) {
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_TEXTBOX_IN_CHANGE_PASSWORD_BY_ID, values);
		sendkeyToElement(driver, MyAccountPageUI.DYNAMIC_TEXTBOX_IN_CHANGE_PASSWORD_BY_ID, value, values);
	}
	
	public void inputToTextboxInCustomerInfoByID(WebDriver driver, String value, String... values) {
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_TEXTBOX_IN_CUSTOMER_INFO_BY_ID, values);
		sendkeyToElement(driver, MyAccountPageUI.DYNAMIC_TEXTBOX_IN_CUSTOMER_INFO_BY_ID, value, values);
	}
	
	public void clickToButtonInMyAccountByText(WebDriver driver, String... values) {
		waitForElementClickable(driver, MyAccountPageUI.DYNAMIC_BUTTON_BY_TEXT, values);
		clickToElement(driver, MyAccountPageUI.DYNAMIC_BUTTON_BY_TEXT, values);
		sleepInSecond(1);
	}
	
	public ProductPageObject clickToProductNameByText(WebDriver driver, String... values) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_PRODUCT_NAME_BY_TEXT, values);
		clickToElement(driver, HomePageUI.DYNAMIC_PRODUCT_NAME_BY_TEXT, values);
		return PageGeneratorManager.getProductPage(driver);
	}
	
	public void selectRatingPointInProductReviewByValue(WebDriver driver, String... ratingValue) {
		waitForElementClickable(driver, ReviewPageUI.DYNAMIC_RATING_RADIO_BUTTON_BY_VALUE, ratingValue);
		clickToElement(driver, ReviewPageUI.DYNAMIC_RATING_RADIO_BUTTON_BY_VALUE, ratingValue);
	}
	
	public String getReviewTitleInProductReviewByProductName(WebDriver driver, String... productName) {
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_REVIEW_TITLE_BY_PRODUCT_NAME, productName);
		return getElementText(driver, MyAccountPageUI.DYNAMIC_REVIEW_TITLE_BY_PRODUCT_NAME, productName);
	}
	
	public String getReviewTextInProductReviewByProductName(WebDriver driver, String... productName) {
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_REVIEW_TEXT_BY_PRODUCT_NAME, productName);
		return getElementText(driver, MyAccountPageUI.DYNAMIC_REVIEW_TEXT_BY_PRODUCT_NAME, productName);
	}
	
	public String getRatingInProductReviewByProductName(WebDriver driver, String... productName) {
		waitForElementVisible(driver, MyAccountPageUI.DYNAMIC_RATING_BY_PRODUCT_NAME, productName);
		return getElementAttribute(driver, MyAccountPageUI.DYNAMIC_RATING_BY_PRODUCT_NAME, "style", productName);
	}
	
	public boolean isDataStringSortedAscending(WebDriver driver, String locator) {
		ArrayList<String> arrayList = new ArrayList<>();
		
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}
		
		ArrayList<String> sortedList = new ArrayList<>();
		
		for (String child : arrayList) {
			sortedList.add(child);
		}
		
		Collections.sort(sortedList);
		
		return sortedList.equals(arrayList);
	}
	
	public boolean isDataStringSortedDescending(WebDriver driver, String locator) {
		ArrayList<String> arrayList = new ArrayList<>();
		
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		
		for (WebElement element : elementList) {
			arrayList.add(element.getText());
		}
		
		ArrayList<String> sortedList = new ArrayList<>();
		
		for (String child : arrayList) {
			sortedList.add(child);
		}
		
		Collections.sort(sortedList);
		
		Collections.reverse(sortedList);
		
		return sortedList.equals(arrayList);
	}
	
	public boolean isDataFloatSortedAscending(WebDriver driver, String locator) {
		ArrayList<Float> arrayList = new ArrayList<Float>();
		
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		
		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		
		ArrayList<Float> sortedList = new ArrayList<Float>();
		
		for (Float child : arrayList) {
			sortedList.add(child);
		}
		
		Collections.sort(sortedList);
		
		return sortedList.equals(arrayList);
	}
	
	public boolean isDataFloatSortedDescending(WebDriver driver, String locator) {
		ArrayList<Float> arrayList = new ArrayList<Float>();
		
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		
		for (WebElement element : elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		
		ArrayList<Float> sortedList = new ArrayList<Float>();
		
		for (Float child : arrayList) {
			sortedList.add(child);
		}
		
		Collections.sort(sortedList);
		
		Collections.reverse(sortedList);
		
		return sortedList.equals(arrayList);
	}
	
	public boolean isDataDateSortedAscending(WebDriver driver, String locator) {
		ArrayList<Date> arrayList = new ArrayList<Date>();
		
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		
		for (WebElement element : elementList) {
			arrayList.add(convertStringToDate(element.getText()));
		}
		
		ArrayList<Date> sortedList = new ArrayList<Date>();
		
		for (Date child : arrayList) {
			sortedList.add(child);
		}
		
		Collections.sort(sortedList);
		
		return sortedList.equals(arrayList);
	}
	
	public boolean isDataDateSortedDescending(WebDriver driver, String locator) {
		ArrayList<Date> arrayList = new ArrayList<Date>();
		
		List<WebElement> elementList = driver.findElements(By.xpath(locator));
		
		for (WebElement element : elementList) {
			arrayList.add(convertStringToDate(element.getText()));
		}
		
		ArrayList<Date> sortedList = new ArrayList<Date>();
		
		for (Date child : arrayList) {
			sortedList.add(child);
		}
		
		Collections.sort(sortedList);
		
		Collections.reverse(sortedList);
		
		return sortedList.equals(arrayList);
	}
	
	public Date convertStringToDate(String dateInString) {
		dateInString = dateInString.replace(",", "");
		
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
		
		Date date = null;
		
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
	private List<WebElement> elements;
}
