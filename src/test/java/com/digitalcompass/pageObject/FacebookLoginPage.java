package com.digitalcompass.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookLoginPage {

	public WebDriver driver;

	public FacebookLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// email/phone number input field
	@FindBy(id = "email")
	@CacheLookup
	WebElement email;

	// password input field
	@FindBy(id = "pass")
	@CacheLookup
	WebElement password;

	// Log in button
	// email/phone number input field
	@FindBy(name = "login")
	@CacheLookup
	WebElement login;

	public void enterEmail(String Useremail) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();
		email.sendKeys(Useremail);

	}

	public void enterPassword(String pass) {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(password));
		password.clear();
		password.sendKeys(pass);
	}

	public void clickLogin() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(login));
		login.click();
	}

}
