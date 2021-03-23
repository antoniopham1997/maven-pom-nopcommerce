package pageUIs;

public class LoginPageUI {
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String LOGIN_BUTTON = "//button[@type='submit' and text()='Log in']";
	
	public static final String EMPTY_EMAIL_MESSAGE = "//span[text()='Please enter your email']";
	public static final String WRONG_EMAIL_MESSAGE = "//span[text()='Wrong email']";
	public static final String NO_CUSTOMER_ACCOUNT_MESSAGE = "//div[text()='Login was unsuccessful. Please correct the errors and try again.']//li[text()='No customer account found']";
	public static final String INVALID_PASSWORD_MESSAGE = "//div[text()='Login was unsuccessful. Please correct the errors and try again.']//li[text()='The credentials provided are incorrect']";
}
