package vn.mycompany.auto.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import vn.mycompany.auto.pages.LoginPage;
import vn.mycompany.auto.pages.ProfilePage;

public class LoginSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9055755063713853593L;
	LoginPage loginPage;
	ProfilePage profilePage;

	@Step
	public void openLoginPage() {
		loginPage.open();
//		getDriver().close();
//		getDriver().get("https://login.skype.com/login");
	}

	@Step
	public void logInSkype(String user, String password) {
		loginPage.loginSkype(user, password);
	}

	@Step
	public String getTitle() {
		return profilePage.getTitle();
	}

	public void inputUser(String user) {
		loginPage.enterUser(user);
	}

	public void inputPassword(String password) {
		loginPage.enterPassword(password);
	}

	public void clickSingInButton() {
		loginPage.clickSignInButton();
	}

	public Object getErrorMsg() {
		return loginPage.getErrorMsg();
	}
}
