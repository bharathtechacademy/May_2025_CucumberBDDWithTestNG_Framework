package com.creatio.crm.application.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.creatio.crm.application.steps.CookiesPageSteps;
import com.creatio.crm.application.steps.HomePageSteps;
import com.creatio.crm.application.steps.LoginPageSteps;
import com.creatio.crm.application.steps.SignUpPageSteps;
import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.utilities.ExcelUtil;

public class BaseTest extends BasePage {

	public LoginPageSteps loginPage;
	public CookiesPageSteps cookiesPage;
	public SignUpPageSteps signUpPage;
	public HomePageSteps homePage;

	@BeforeMethod(alwaysRun = true, dependsOnMethods = "setupBrowser")
	public void initializePageClasses() {
		WebDriver driver = BasePage.getDriver();
		loginPage = new LoginPageSteps(driver);
		cookiesPage = new CookiesPageSteps(driver);
		signUpPage = new SignUpPageSteps(driver);
		homePage = new HomePageSteps(driver);
	}
	
	
	@DataProvider(name = "TestData")
	public String [][] getTestData(Method method) {
		String [][] data = ExcelUtil.readExcelData("TestData.xlsx", method.getName());
		return data;
	}

}
