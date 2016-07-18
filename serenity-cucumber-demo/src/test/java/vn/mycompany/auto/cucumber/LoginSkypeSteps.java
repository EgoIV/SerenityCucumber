package vn.mycompany.auto.cucumber;

import java.util.List;

import net.thucydides.core.annotations.Steps;

import org.junit.Assert;

import vn.mycompany.auto.steps.LoginSteps;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSkypeSteps {

	@Steps
	LoginSteps loginSteps;

	@Given("^Open Login skype page$")
	public void open_Login_skype_page() throws Throwable {
		loginSteps.openLoginPage();
	}

	@When("^\"([^\"]*)\" logged in with password is \"([^\"]*)\"$")
	public void logged_in_with_password_is(String user, String password) {
		loginSteps.logInSkype(user, password);
	}

	@Then("^I verify page title is \"([^\"]*)\"$")
	public void i_verify_page_title_is(String title) throws Throwable {
		Assert.assertEquals(loginSteps.getTitle(), title);
	}

	@When("^I am input username is \"([^\"]*)\"$")
	public void i_am_input_username_is(String user) throws Throwable {
		loginSteps.inputUser(user);
	}

	@And("^I am input password is \"([^\"]*)\"$")
	public void i_am_input_password_is(String password) throws Throwable {
		loginSteps.inputPassword(password);
	}

	@And("^user click Signin button$")
	public void user_click_Signin_button() throws Throwable {
		loginSteps.clickSingInButton();
	}

	@Then("^I verify the error message is \"([^\"]*)\"$")
	public void i_verify_the_error_message_is(String message) throws Throwable {
		System.out.println(loginSteps.getErrorMsg());
		System.out.println(message);
		Assert.assertEquals(loginSteps.getErrorMsg(), message);
	}

	@When("^I fill the login from$")
	public void i_fill_the_login_from(DataTable data) throws Throwable {
		List<List<String>> account = data.raw();
		loginSteps.inputUser(account.get(1).get(0));
		loginSteps.inputPassword(account.get(1).get(1));
		loginSteps.clickSingInButton();
		// Map<String, String> account;
		// account = new HashMap<String, String>();
		// for (DataTableRow row : data.getGherkinRows()) {
		// account.put(row.getCells().get(0),row.getCells().get(1));
		// }
	}

	@After
	public void close() {
		loginSteps.getDriver().close();
	}
}
