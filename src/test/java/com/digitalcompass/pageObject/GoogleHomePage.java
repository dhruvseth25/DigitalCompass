package com.digitalcompass.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage {

	public WebDriver driver;

	public GoogleHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Sign In button
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	@CacheLookup
	WebElement signin;
	
	

	// Click on Sign In button
	public void clickSignIn() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(signin));
		signin.click();
	}
	
	//Providing Password
	
	
}
