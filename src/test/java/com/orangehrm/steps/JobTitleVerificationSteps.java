package com.orangehrm.steps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.JobTitleVerificationPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utils.CommonMethods;
import com.orangehrm.utils.ConfigsReader;
import com.orangehrm.utils.DbUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JobTitleVerificationSteps extends CommonMethods{

	LoginPage login;
	HomePage home;
	JobTitleVerificationPage job;
	
	@Given("I logged into OrangeHrm")
	public void i_logged_into_OrangeHrm() {
		login = new LoginPage();
		home = new HomePage();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		click(login.loginBtn);
	}

	@Given("I click on the Admin link")
	public void i_click_on_the_Admin_link() {
	  click(job.AdminLink);
	}

	@Given("I click on the Job link")
	public void i_click_on_the_Job_link() {
	   click(job.JobLink);
	}

	@When("I click on Job Titles")
	public void i_click_on_Job_Titles() {
	   click(job.JobTitleLink);
	}

	@When("I get all Job Titles from UI")
	public void i_get_all_Job_Titles_from_UI() {
	  List<Map<String, String>> uiResults=new ArrayList();
	  System.out.println("----Printing Results from UI-----");
	  
		for(WebElement row:job.jobTitleTableRows) {
			Map<String, String> uiDataMap=new LinkedHashMap();
			
			String text=row.getText().replace("ohrm_edit", "").trim();
			uiDataMap.put("Job_Title", text);
			uiResults.add(uiDataMap);
		}
		System.out.println(uiResults);
		
	}

	@When("I execute {string} from Database")
	public void i_execute_from_Database(String sqlQuery) {
	    List<Map<String, String>> dbResults=DbUtils.getResultSetData(sqlQuery);
	    dbResults = DbUtils.getResultSetData(sqlQuery);
	
	    System.out.println(dbResults);
	    
	}

	@Then("Job titles are matched")
	public void i_see_results_from_UI_and_Database_are_matched() {
	    	}


}
