package pageUIs;

public class MyAccountPageUI {
	public static final String DYNAMIC_BUTTON_BY_TEXT = "//button[text()='%s']";
	public static final String SAVE_BUTTON = "//button[text()='Save']";
	public static final String ADD_NEW_BUTTON = "//button[text()='Add new']";
	public static final String CHANGE_PASSWORD_BUTTON = "//button[text()='Change password']";
	public static final String DYNAMIC_GENDER_BY_ID = "//input[@id='gender-%s']";
	public static final String DYNAMIC_DOB_DROPDOWN_BY_NAME = "//select[@name='DateOfBirth%s']";
	public static final String DYNAMIC_LINK_BY_TEXT = "//div[@class='listbox']//a[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_IN_ADDRESSES_BY_ID = "//select[@id='Address_%sId']";
	public static final String DYNAMIC_ADDRESSES_INFORMATION_BY_CLASS = "//li[@class='%s']";
	public static final String DYNAMIC_TEXTBOX_IN_CUSTOMER_INFO_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_TEXTBOX_IN_ADDRESSES_BY_ID = "//input[@id='Address_%s']";
	public static final String DYNAMIC_TEXTBOX_IN_CHANGE_PASSWORD_BY_ID = "//input[@id='%s']";
	public static final String CHANGE_PASSWORD_SUCCESS_MESSAGE = "//p[text()='Password was changed']";
	public static final String LOG_OUT_LINK = "//a[@class='ico-logout']";
	public static final String CLOSE_CHANGE_PASSWORD_MESSAGE_BUTTON = "//span[@class='close']";
	public static final String DYNAMIC_REVIEW_TITLE_BY_PRODUCT_NAME = "//a[text()='%s']/parent::span/parent::div/parent::div/preceding-sibling::div//strong";
	public static final String DYNAMIC_REVIEW_TEXT_BY_PRODUCT_NAME = "//a[text()='%s']/parent::span/parent::div/preceding-sibling::div";
	public static final String DYNAMIC_RATING_BY_PRODUCT_NAME = "//a[text()='%s']/parent::span/parent::div/parent::div/preceding-sibling::div//div[@class='rating']/div";
}
