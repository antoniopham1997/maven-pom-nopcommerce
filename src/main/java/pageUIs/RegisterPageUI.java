package pageUIs;

public class RegisterPageUI {
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String FIRST_NAME_EMPTY_ERROR_MESSAGE = "//span[@id='FirstName-error' and text()='First name is required.']";
	public static final String LAST_NAME_EMPTY_ERROR_MESSAGE = "//span[@id='LastName-error' and text()='Last name is required.']";
	public static final String EMAIL_EMPTY_ERROR_MESSAGE = "//span[@id='Email-error' and text()='Email is required.']";
	public static final String EMAIL_INVALID_ERROR_MESSAGE = "//span[@id='Email-error' and text()='Wrong email']";
	public static final String PASSWORD_EMPTY_ERROR_MESSAGE = "//span[@id='Password-error' and text()='Password is required.']";
	public static final String CONFIRM_PASSWORD_EMPTY_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error' and text()='Password is required.']";
	public static final String ALREADY_EXISTS_EMAIL_ERROR_MESSAGE = "//div[@class='message-error validation-summary-errors']//li[text()='The specified email already exists']";
	public static final String INVALID_PASSWORD_ERROR_MESSAGE = "//span[@id='Password-error']/p[text()='Password must meet the following rules: ']/following-sibling::ul/li[text()='must have at least 6 characters']";
	public static final String INVALID_CONFIRM_PASSWORD_ERROR_MESSAGE = "//span[@id='ConfirmPassword-error' and text()='The password and confirmation password do not match.']";
	public static final String REGISTER_SUCCESS_MESSAGE = "//div[text()='Your registration completed']";
	
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_GENDER_BUTTON_BY_ID = "//input[@id='gender-%s']";
	public static final String DYNAMIC_DOB_DROPDOWN_BY_NAME = "//select[@name='DateOfBirth%s']";
}

