package com.creatio.crm.application.stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.creatio.crm.application.steps.CookiesPageSteps;
import com.creatio.crm.application.steps.HomePageSteps;
import com.creatio.crm.application.steps.LoginPageSteps;
import com.creatio.crm.application.steps.SignUpPageSteps;
import com.creatio.crm.framework.base.BasePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplicationStepDefinitions {
	
	public LoginPageSteps loginPage;
	public CookiesPageSteps cookiesPage;
	public SignUpPageSteps signUpPage;
	public HomePageSteps homePage;

	@Given("Initialize page objects")
	public void initializePageClasses() {
		WebDriver driver = BasePage.getDriver();
		loginPage = new LoginPageSteps(driver);
		cookiesPage = new CookiesPageSteps(driver);
		signUpPage = new SignUpPageSteps(driver);
		homePage = new HomePageSteps(driver);
	}

	@Given("Launch the application")
	public void launch_the_application() {		
		loginPage.launchApplication();
	}

	@Then("Verify cookies pop-up is displayed")
	public void verify_cookies_pop_up_is_displayed() {
		cookiesPage.verifyCookiesPopUpDisplayed();		
	}

	@Then("verify Cookies Popup Logos")
	public void verify_cookies_popup_logos() {
		cookiesPage.verifyCookiesPopUpLogosDisplayed();		
	}

	@Then("verify Cookies Popup buttons are displayed")
	public void verify_cookies_popup_buttons_are_displayed() {
		cookiesPage.verifyCookiesPopUpButtonsDisplayed();		
	}

	@Then("verify Cookies Popup switch buttons are displayed")
	public void verify_cookies_popup_switch_buttons_are_displayed() {
		cookiesPage.verifyCookiesPopUpSwitchesDisplayed();		
	}

	@Then("verify that the necessary switch button is disabled")
	public void verify_that_the_necessary_switch_button_is_disabled() {
		cookiesPage.verifyNecessarySwitchDisabled();		
	}

	@When("user clicks on the Show details link")
	public void user_clicks_on_the_show_details_link() {
		cookiesPage.clickShowDetailsLink();		
	}

	@Then("cookies pop-up should be displayed in expanded view")
	public void cookies_pop_up_should_be_displayed_in_expanded_view() {
		cookiesPage.verifyCookiesPopUpExpandedDetailsDisplayed();				
	}

	@When("user selects the option to {string}")
	public void user_selects_the_option_to(String string) {
		cookiesPage.selectCookies(string);		
	}

	@Then("the cookies popup should be closed")
	public void the_cookies_popup_should_be_closed() {
		cookiesPage.verifyCookiesPopUpClosed();		
	}

	@Then("Verify cookies popup is displayed successfully")
	public void verify_cookies_popup_is_displayed_successfully() {
		cookiesPage.verifyCookiesPopUpDisplayed();		
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		loginPage.clickLoginButton();			
	}

	@Then("Login Should be successful")
	public void login_should_be_successful() {
		homePage.verifyLoginIsSuccessful();		
	}

	@When("User click on the SignUp link")
	public void user_click_on_the_sign_up_link() {
		loginPage.clickSignUpLink();		
	}

	@Then("SignUp page should be launched")
	public void sign_up_page_should_be_launched() {
		signUpPage.verifySignUpPageIsLaunched();	
	}

	@When("Click on Continue button")
	public void click_on_continue_button() {
		signUpPage.clickOnContinueButton();		
	}

	@When("Enter Company Details")
	public void enter_company_details() {
		signUpPage.enterCompanyDetails();		
	}

	@When("Click on SignUp button")
	public void click_on_sign_up_button() {
		signUpPage.clickOnSignUpButton();		
	}

	@Then("SignUp should be successful")
	public void sign_up_should_be_successful() {
		homePage.verifySignUpIsSuccessful();		
	}	

	@When("^User enter (.*) and (.*)$")
	public void enterCredentials(String email, String password) {
		loginPage.enterCredentials(email, password);		
	}
	
	@When("^User entered (.*) and (.*)$")
	public void enterUserDetails(String email, String password) {
		signUpPage.enterUserDetails(email, password);		
	}

	@Then("verify cookies pop-up <content>.")
	public void verify_cookies_pop_up_content(DataTable dataTable) {
		List<String> content = dataTable.asList();
		String expectedContent = content.get(1);
		cookiesPage.verifyCookiesPopUpContent(expectedContent);
	}

}
