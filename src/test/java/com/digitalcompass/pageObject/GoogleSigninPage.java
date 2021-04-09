package com.digitalcompass.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSigninPage {

	public WebDriver driver;

	public GoogleSigninPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// UserId / emailId / phonenumber field
	@FindBy(id = "identifierId")
	@CacheLookup
	WebElement userid;

	// Next button
	@FindBy(className = "VfPpkd-RLmnJb")
	@CacheLookup
	WebElement next;

	// Password input field
	@FindBy(className = "Xb9hP ")
	@CacheLookup
	WebElement passwordfield;
	
	//String Text when providing Invalid userId
	/*@FindBy(className = "o6cuMc")
	@CacheLookup
	WebElement denymsg;*/

	// Providing userId
	public void setUserId(String userID) {
		userid.clear();
		userid.sendKeys(userID);
	}

	// Click on Next button
	public void clickNext() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(next));
		next.click();
	}

	// Providing Password
	public void enterPassword() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(passwordfield));
		passwordfield.clear();
		passwordfield.sendKeys("12345325");
	}
	
	public String userDeniedID() {
		String denymsg = driver.findElement(By.className("o6cuMc")).getText();
		return denymsg;
	}
}
