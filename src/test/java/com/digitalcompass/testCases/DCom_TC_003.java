package com.digitalcompass.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.digitalcompass.pageObject.FacebookHomePage;
import com.digitalcompass.pageObject.FacebookLoginPage;
import com.digitalcompass.testBase.BaseClass;

public class DCom_TC_003 extends BaseClass {

	// Description: This test case is verifying that the user can successfully log
	// in and log out.
	// Acceptance criteria :a) The user is should be prompted to home page
	// b) The user is able to click on log out button
	// c) The user should be prompted to the login page back again

	@Test
	public void fbLoginTest() throws IOException {
		logger.info("Starting test case DCom_'TC_003");

		driver.get(configPropObj.getProperty("baseURL2"));

		logger.info("Facebook Login page is opened");

		FacebookLoginPage flp = new FacebookLoginPage(driver);
		flp.enterEmail(configPropObj.getProperty("userid3"));
		logger.info("User has entered the emailid");

		flp.enterPassword(configPropObj.getProperty("fbcorrectpassword"));

		flp.clickLogin();
		logger.info("User has clicked on the login button");

		logger.info("User is in the home page");
		FacebookHomePage fhp = new FacebookHomePage(driver);
		fhp.clickDropdown();
		logger.info("user has clicked on the drop down");

		fhp.clickLogout();
		logger.info("User has sucessfully logged out");
		logger.info("Test Case has successfully passed");
		captureScreen(driver, "fbLoginTest");

	}
}
