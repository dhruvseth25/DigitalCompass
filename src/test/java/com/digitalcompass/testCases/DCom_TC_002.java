package com.digitalcompass.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.digitalcompass.pageObject.GoogleHomePage;
import com.digitalcompass.pageObject.GoogleSigninPage;
import com.digitalcompass.testBase.BaseClass;

public class DCom_TC_002 extends BaseClass {

	// Description: This test case is verifying the user has is denied when entering an invalid userID.
	// Acceptance criteria :a) The user is denied access to enter the password
	// b) The user is notified with an error message ("Couldn't find your google account")

	@Test
	public void invalidLoginTest() throws IOException {

		logger.info("Starting test case DCom_'TC_002");

		driver.get(configPropObj.getProperty("baseURL"));

		logger.info("Google Home page is opened");
		String exp_title = "Google";
		String act_title = driver.getTitle();
		if (exp_title.equals(act_title)) {
			Assert.assertTrue(true);
			logger.info("Page Title verified");
		} else {
			Assert.assertTrue(false);
			logger.error("Page Title is correct. Test Case Failed");
		}

		GoogleHomePage hp = new GoogleHomePage(driver);
		hp.clickSignIn();
		logger.info("User has clicked on the signin button");

		logger.info("Providing userId");
		GoogleSigninPage sp = new GoogleSigninPage(driver);
		sp.setUserId(configPropObj.getProperty("userid2"));
		sp.clickNext();
		logger.info("User has clicked on the next button");
		
		String msg=sp.userDeniedID();
		if(msg.equalsIgnoreCase("Couldn’t find your Google Account"))
		{
			Assert.assertTrue(true);
			logger.info("The User is notified that access is denied ");
			logger.info("Test case has passed ");
			System.out.println(msg);
			captureScreen(driver,"invalidLoginTest");
		}
		else
		{
			logger.error("Test case has failed");
			captureScreen(driver,"invalidLoginTest");
			Assert.assertTrue(false);
		}
		logger.info("User has denied the access and asked to verify the userId");
	}
}
