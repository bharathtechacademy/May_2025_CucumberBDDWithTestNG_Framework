package com.creatio.crm.framework.base;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.creatio.crm.framework.utilities.PropUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BasePage{

	// This class will have all the base common methods and configurations to begin the test execution.(like browser setup, teardown, etc.)

	private static WebDriver driver;
	Properties prop = PropUtil.readData("config.properties");
	
	// Common method to get the WebDriver instance and to launch the browser

	@Before
	public void setupBrowser() {
		String browserName=prop.getProperty("BROWSER");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			Assert.fail("Browser not supported");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	
	// Common method to teardown the WebDriver instance
	@After(order=0)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	// common method to take screenshot and attach it to the report
	@After(order=1)
	public void failedTestListener(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
	
	// Method to get the WebDriver instance
	public static WebDriver getDriver() {
		return driver;
	}
	
	// Method to set the new WebDriver instance
	public static void setDriver(WebDriver newDriver) {
		driver = newDriver;
	}
	
}
