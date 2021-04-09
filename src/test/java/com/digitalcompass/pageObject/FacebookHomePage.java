package com.digitalcompass.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookHomePage {

	public WebDriver driver;

	public FacebookHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Dropdown arrow to sign out
	@FindBy(css = "div[aria-label=\"Account\"]")
	@CacheLookup
	WebElement dropdown;

	// Click on Log out button
	@FindBy(xpath = "//span[contains(text(),'Log Out')]")
	@CacheLookup
	WebElement logout;

	public void clickDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		dropdown.click();
	}

	public void clickLogout() {
		
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		logout.click();
	}
}
