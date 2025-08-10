package com.creatio.crm.framework.web.commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.constants.Constants;
import com.creatio.crm.framework.utilities.PropUtil;

public class WebCommons {
	
	// This class will have all the common methods related to web operations /web elements.	
	
	public WebDriver driver = BasePage.getDriver();
	public Properties properties = PropUtil.readData("Config.properties");
	
	//Common method to launch the application and verify the title
	public void launchApplication() {
		String url = properties.getProperty("APP_URL");
		String expectedTitle = properties.getProperty("APP_TITLE");
		driver.get(url);
		String actualTitle = driver.getTitle();
		if (!actualTitle.equals(expectedTitle)) {
			Assert.fail("Application did not launch successfully. Expected title: " + expectedTitle + ", but got: " + actualTitle);
		}
	}
	
	// Common method to Scroll to an element
	public void scrollToElement(WebElement element) {		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	// Common method to click on an element
	public void click(WebElement element) {
		scrollToElement(element);
		element.click();
	}
	
	// Common method to click on an hidden element using JavaScript
	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	// Common method to double click on an element
	public void doubleClick(WebElement element) {
		scrollToElement(element);
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	// Common method to right click on an element
	public void rightClick(WebElement element) {
		scrollToElement(element);
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	// Common method to mouse hover over an element
	public void mouseHover(WebElement element) {
		scrollToElement(element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	// Common method to select the checkbox element
	public void selectCheckbox(WebElement checkbox, boolean status) {
		scrollToElement(checkbox);
		if (checkbox.isSelected() != status) {
			checkbox.click();
		}
	}
	
	// Common method to enter text to an textbox element
	public void enterText(WebElement element, String text) {
		scrollToElement(element);
		if (element.isDisplayed() && element.isEnabled()) {
			element.clear();
			element.sendKeys(text);
		} else {
			Assert.fail("Element is not interactable. Element: " + element.toString());
		}
	}
	
	// method to enter text in textbox using actions class
	public void enterInfo(WebElement textbox, String textValue) {
		scrollToElement(textbox);
		new Actions(driver).sendKeys(textbox, textValue).perform();
	}
	
	// Common method to select the option from a dropdown element
	public void selectOption(WebElement dropdown, String option, String selectBy) {
		scrollToElement(dropdown);
		Select select = new Select(dropdown);
		if (selectBy.equalsIgnoreCase("visibleText")) {
			select.selectByVisibleText(option);
		} else if (selectBy.equalsIgnoreCase("value")) {
			select.selectByValue(option);
		} else if (selectBy.equalsIgnoreCase("index")) {
			select.selectByIndex(Integer.parseInt(option));
		}
	}
	
	// Common method to get the text from an element
	public String getText(WebElement element) {
		return element.getText();
	}
	
	// Common method to get the attribute value from an element
	public String getAttribute(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}
	
	// Common method to get the current URL of the page
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	// Common method to refresh the current page
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	// Common method to wait (java wait)
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Common method to wait using implicit wait
	public void setImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.TIMEOUT));
	}
	
	// Common method to wait using explicit wait
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	// Common method to wait using explicit wait
	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));
	}
	
	// Common method to wait for an element to be clickable
	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	// Common method to wait for an element to be disappeared
	public void waitForElementToDisappear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	// Common method to wait for an alert to be present
	public void waitForAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	// Common method to accept/reject an alert
	public void handleAlert(boolean accept) {
		waitForAlert();
		if (accept) {
			driver.switchTo().alert().accept();
		} else {
			driver.switchTo().alert().dismiss();
		}
	}
	
	// generate unique id
	public String uniqueId(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String uniqueId = sdf.format(Calendar.getInstance().getTime());
		return uniqueId;
	}
	
	// Common method to take a screenshot of the current page
	public static String takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+screenshotName+".png";
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		return screenshotPath;
	}
	
	// Common method to take a screenshot of the web element
	public static String takeScreenshot(WebElement element, String screenshotName) throws IOException {
		String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+screenshotName+".png";
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		return screenshotPath;
	}
	
	// Common method to switch to a frame by name or ID
	public void switchToFrame(String frameNameOrId) {
		driver.switchTo().frame(frameNameOrId);
	}
	
	// Common method to switch to default frame/main window
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	//Common method to switch to a frame by WebElement
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	//Common method to switch to window by id
	public void switchToWindow(String windowId) {
		driver.switchTo().window(windowId);
	}
	
		
	
}
