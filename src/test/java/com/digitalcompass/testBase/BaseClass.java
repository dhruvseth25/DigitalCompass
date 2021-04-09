package com.digitalcompass.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public Properties configPropObj;
	public WebDriver driver;

	public Logger logger = LogManager.getLogger(this.getClass()); // Log4j2 // this code is automatically internally
																	// read the log4j2 file from resources

	@BeforeClass
	@Parameters("browser")
	public void setup(String br) throws IOException {

		// Loading the config.properties file
		configPropObj = new Properties();
		FileInputStream configfile = new FileInputStream(".\\resources\\config.properties");
		configPropObj.load(configfile);
		// End of loading config.properties file

		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			// To remove infobars
			options.addArguments("disable-infobars");
			options.addArguments("--disable-web-security");
			driver = new ChromeDriver(options);
		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (br.equals("edge")) {
			// WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	//Method for capturing screenshot when the testcase has failed.
	//Tname is the name of the test method which is under test (@Test)
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}
