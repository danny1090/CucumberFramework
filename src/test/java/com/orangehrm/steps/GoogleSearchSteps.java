package com.orangehrm.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class GoogleSearchSteps {

	WebDriver driver;
	@Given("I navigate to Google")
	public void i_navigate_to_Google() {
	    System.out.println("I am on google page");
	    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
	    WebDriver driver=new ChromeDriver();
	  
	}

	@When("I type search item")
	public void i_type_search_item() {
		System.out.println("I search for item");
		driver.findElement(By.id("fakebox-input")).sendKeys("youtube");
	}

	@When("I click on google search button")
	public void i_click_on_google_search_button() {
		System.out.println("clicked search item");
		WebElement search=driver.findElement(By.id("loginbtn"));
		search.click();
		
	}

	@Then("I see search results are displayed")
	public void i_see_search_results_are_displayed() {
		boolean logo=driver.findElement(By.xpath("//span[text()='YouTube]'")).isDisplayed();
		Assert.assertTrue(logo);
		System.out.println("Results are displayed");
	}

}
