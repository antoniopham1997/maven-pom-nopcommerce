package pageUIs;

public class ReviewPageUI {
	public static final String REVIEW_TITLE_TEXTBOX = "//input[@class='review-title']";
	public static final String REVIEW_TEXT_TEXTAREA = "//textarea[@class='review-text']";
	public static final String DYNAMIC_RATING_RADIO_BUTTON_BY_VALUE = "//div[@class='rating-options']/input[@value='%s']";
	public static final String SUBMIT_REVIEW_BUTTON = "//button[text()='Submit review']";
	public static final String PRODUCT_REVIEW_SUCCESS_MESSAGE = "//div[@class='result' and contains(text(),'Product review is successfully added.')]";
	public static final String MY_ACCOUNT_LINK = "//a[@class='ico-account']";
}
