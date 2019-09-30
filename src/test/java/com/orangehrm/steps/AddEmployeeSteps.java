package com.orangehrm.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orangehrm.pages.AddEmployeePage;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;


public class AddEmployeeSteps extends CommonMethods {

	LoginPage login;
	HomePage home;
	AddEmployeePage emp;

	@Given("I logged into OrangeHrm successfully")
	public void i_logged_into_OrangeHrm_successfully() {
		login = new LoginPage();
		home = new HomePage();
		emp = new AddEmployeePage();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@When("I click on PIM link")
	public void i_click_on_PIM_link() {
		click(home.PIM);

	}

	@When("I click on Add Employee link")
	public void i_click_on_Add_Employee_link() {
		WebElement addEmp = driver.findElement(By.xpath("//span[text()='Add Employee']"));
		click(home.addEmployee);
	}

	@When("I provide {string}, {string}, {string}, {string}")
	public void i_provide(String fName, String mName, String lName, String location) {
		sendText(emp.firstName, fName);
		sendText(emp.middleName, mName);
		sendText(emp.lastName, lName);
		click(emp.location);
		selectList(emp.locationList, location);
	}

	@When("I click on save button")
	public void i_click_on_save_button() {
		click(emp.saveBtn);
	}

	@Then("I see {string}, {string} is displayed")
	public void i_see_is_displayed(String fName, String lName) {
		waitForElementBeClickable(emp.empCheck, 20);
		String empName=emp.empCheck.getText();
		Assert.assertEquals(fName+" "+lName, empName);
	}
	
	@Then("I see following labels")
	public void i_see_following_labels(DataTable addEmpLabels) {
		
	    List<String> expectedLabels=addEmpLabels.asList();
	    System.out.println("----Printing labels from cucumber dataTable----");
	    for(String label: expectedLabels) {
	    	System.out.println(label);
	    }
	    //create an empty arrayList where we store labels list
	    List<String> actualLabels=new ArrayList<String>();
	    
	    //get all label elements
	    System.out.println("----Printing labels text from application----");
	    List<WebElement> labelList=emp.addEmpLabels;
	    for(WebElement label:labelList) {
	    	String labeltxt=label.getText();
	    	if(!labeltxt.isEmpty()) {
	    		actualLabels.add(labeltxt.replace("*", ""));
	    	}
	    	
	    }
	    
	}
	
	
	
	/*
	 * @When("I provide firstname, middlename, lastname and location") public void
	 * i_provide_firstname_middlename_lastname_and_location() {
	 * 
	 * }
	 * 
	 * 
	 * @When("I click on create login details") public void
	 * i_click_on_create_login_details() {
	 * 
	 * }
	 * 
	 * @When("I provide all mandatory fields") public void
	 * i_provide_all_mandatory_fields() {
	 * 
	 * }
	 */

}
