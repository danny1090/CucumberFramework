package com.orangehrm.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class LoginSteps extends CommonMethods {

	LoginPage login;

	@Given("I navigate to OrangeHrm")
	public void i_navigate_to_OrangeHrm() {
		setUp();
	}

	@Given("I see OrangeHrm logo")
	public void i_see_OrangeHrm_logo() {
		login = new LoginPage();
		boolean isDisplayed = login.logo.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}

	@When("I enter a valid username and password")
	public void i_enter_a_valid_username_and_password() {
		sendText(login.userName, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("I click the login button")
	public void i_click_the_login_button() {
		click(login.loginBtn);
	}

	@Then("I successfully logged in")
	public void i_successfully_logged_in() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.dashboardText.isDisplayed());
	}

	@Then("I close browser")
	public void i_close_browser() {
		tearDown();
	}

	@When("I enter a invalid username and password")
	public void i_enter_a_invalid_username_and_password() {
		sendText(login.userName, "Test");
		sendText(login.password, "Test123");
	}

	@Then("I see error message is displayed")
	public void i_see_error_message_is_displayed() {
		Assert.assertTrue(login.error.isDisplayed());
		String errorText = login.error.getText();
		Assert.assertEquals("Invalid Credentials", errorText);
	}

	@When("I enter a invalid username and password I see errorMessage")
	public void i_enter_a_invalid_username_and_password_I_see_errorMessage(DataTable wrongCredentials) {
		List<Map<String, String>> maps = wrongCredentials.asMaps();
		
		for(Map<String, String> map:maps) {
			System.out.println(map.get("UserName"));
			System.out.println(map.get("Password"));
			System.out.println(map.get("ErrorMessage"));
			System.out.println("------------------------------------");
			
			//passing username and password values through datatable/map
			sendText(login.userName, map.get("UserName"));
			sendText(login.password, map.get("Password"));
			click(login.loginBtn);
			
			//verifying text of error message
			String actualError=login.error.getText().trim();
			String expectedError=map.get("ErrorMessage");
			Assert.assertEquals(expectedError, actualError);
			
			
		}
	}

}
