package com.creatio.crm.application.tests;

import org.testng.annotations.Test;

public class ApplicationTest extends BaseTest {

	@Test(priority = 1)
	public void verifyCookiesPopUpIsDisplayed() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpDisplayed();
	}
	
	@Test(priority = 2, dataProvider = "TestData")
	public void verifyCookiesPopUpContent(String expectedContent) {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpDisplayed();
		cookiesPage.verifyCookiesPopUpContent(expectedContent);
	}
	
	@Test(priority = 3)
	public void verifyCookiesPopUpLogos() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpDisplayed();
		cookiesPage.verifyCookiesPopUpLogosDisplayed();
	}
	
	@Test(priority = 4)
	public void verifyCookiesPopUpButtons() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpDisplayed();
		cookiesPage.verifyCookiesPopUpButtonsDisplayed();
	}
	
	@Test(priority = 5)
	public void verifyCookiesPopUpSwitchButtons() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpDisplayed();
		cookiesPage.verifyCookiesPopUpSwitchesDisplayed();
		cookiesPage.verifyNecessarySwitchDisabled();
	}
	
	@Test(priority = 6)
	public void verifyShowDetailsInCookiesPopup() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpDisplayed();
		cookiesPage.clickShowDetailsLink();
		cookiesPage.verifyCookiesPopUpExpandedDetailsDisplayed();
	}
	
	@Test(priority = 7)
	public void verifyCookiesPopUpWhenUserAcceptCookies() {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpDisplayed();
		cookiesPage.selectCookies("Allow All");
		cookiesPage.verifyCookiesPopUpClosed();
	}
	
	@Test(priority = 8,dataProvider = "TestData")
	public void verifyApplicationSignUp(String email, String password) {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpDisplayed();
		cookiesPage.selectCookies("Allow All");
		cookiesPage.verifyCookiesPopUpClosed();
		loginPage.clickSignUpLink();
		signUpPage.verifySignUpPageIsLaunched();
		signUpPage.enterUserDetails(email, password);
		signUpPage.clickOnContinueButton();
		signUpPage.enterCompanyDetails();
		signUpPage.clickOnSignUpButton();
		homePage.verifySignUpIsSuccessful();
	}
	
	@Test(priority = 9,dataProvider = "TestData")
	public void verifyLoginWithSignUpUser(String email, String password) {
		loginPage.launchApplication();
		cookiesPage.verifyCookiesPopUpDisplayed();
		cookiesPage.selectCookies("Allow All");
		cookiesPage.verifyCookiesPopUpClosed();
		loginPage.verifyLoginPageHeader();
		loginPage.enterCredentials(email, password);
		loginPage.clickLoginButton();
		homePage.verifyLoginIsSuccessful();
	}
	
}
