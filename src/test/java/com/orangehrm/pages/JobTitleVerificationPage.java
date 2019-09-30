package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobTitleVerificationPage {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='menu_admin_viewAdminModule']/a/span[2]")
	public WebElement AdminLink;
	
	@FindBy(xpath="//*[@id='menu_admin_Job']/a/span[2]")
	public WebElement JobLink;
	
	@FindBy(xpath="//*[@id='menu_admin_viewJobTitleList']/span[2]")
	public WebElement JobTitleLink;
	
	@FindBy(xpath = "//table[@class='highlight bordered']/tbody/tr/td[2]")
	public List<WebElement> jobTitleTableRows;
	
	public JobTitleVerificationPage() {
		PageFactory.initElements(driver, this);
	}	
}
