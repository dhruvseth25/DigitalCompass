package com.digitalcompass.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.digitalcompass.pageObject.GoogleHomePage;
import com.digitalcompass.pageObject.GoogleSigninPage;
import com.digitalcompass.testBase.BaseClass;

public class DCom_TC_001 extends BaseClass {

	// Description: This test case is verifying the user has entered a valid userID.
	// Acceptance criteria :a) The user is promted to enter the password
	// b) The user should be able to view his userID

	@Test
	public void loginTest() {

		logger.info("Starting test case DCom_'TC_001");

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
		sp.setUserId(configPropObj.getProperty("userid1"));
		sp.clickNext();
		logger.info("User has clicked on the next button");
		// sp.enterPassword();*/

	}

}
