package vn.mycompany.auto.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://login.skype.com/login")
public class LoginPage extends PageObject {

	@FindBy(id = "username")
	WebElement userFeild;

	@FindBy(id = "password")
	WebElement passwordFeild;

	@FindBy(id = "signIn")
	WebElement signInButton;

	@FindBy(xpath = "//div[@role='alert' and not(@id)]/span")
	WebElement errorMessage;

	public void enterUser(String user) {
		userFeild.sendKeys(user);
	}

	public void enterPassword(String password) {
		passwordFeild.sendKeys(password);
	}

	public void clickSignInButton() {
		signInButton.click();
	}

	public void loginSkype(String user, String password) {
		enterUser(user);
		enterPassword(password);
		clickSignInButton();
	}

	public String getErrorMsg() {
		return errorMessage.getText();
	}
}
