package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.application.elements.LoginPageElements;

public class LoginPageSteps extends LoginPageElements {

	public LoginPageSteps(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Verify the login page header
	public void verifyLoginPageHeader() {
		waitForElement(loginPageHeader);
	}
	
	// Enter business email and Password
	public void enterCredentials(String businessEmail, String password) {
		waitForElement(businessEmailTxtb);
		enterText(businessEmailTxtb,businessEmail);
		waitForElement(passwordTxtb);
		enterText(passwordTxtb, password);
	}
	
	// Click on the login button
	public void clickLoginButton() {
		waitForElement(loginBtn);
		click(loginBtn);
	}
	
	// Click on the forgot password link
	public void clickForgotPasswordLink() {
		waitForElement(forgotPasswordLink);
		click(forgotPasswordLink);
	}

	// Click on the Sign-up link
	public void clickSignUpLink() {
		waitForElement(signUpLink);
		click(signUpLink);
	}
	
	// Verify the Social Media Icons
	public void verifySocialMediaIcons() {
		waitForElement(linkedInIcon);
		waitForElement(googleIcon);
		waitForElement(facebookIcon);
	}
	
	// Verify the Sign-up header
	public void verifySignUpHeader() {
		waitForElement(signUpHeader);
	}
	
	
	
}
