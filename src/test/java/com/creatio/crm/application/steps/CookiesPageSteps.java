package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.application.elements.CookiesPageElements;

public class CookiesPageSteps extends CookiesPageElements {
	
	//Initialize all the elements using page factory every time when this class is instantiated
	public CookiesPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}

	// Verify that the cookies pop-up is displayed
	public void verifyCookiesPopUpDisplayed() {
		waitForElement(cookiesHeader);
	}

	// Verify that the cookies pop-up content is displayed
	public void verifyCookiesPopUpContent(String expectedContent) {
		waitForElement(cookiesContent);
		String actualContent = cookiesContent.getText();
		Assert.assertEquals(actualContent, expectedContent);
	}

	// Verify the cookies pop-up logo's are displayed
	public void verifyCookiesPopUpLogosDisplayed() {
		waitForElement(creatioLogo);
		waitForElement(cookiebotLogo);
	}

	// Verify the cookie selection buttons in the cookies pop-up
	public void verifyCookiesPopUpButtonsDisplayed() {
		waitForElement(allowAllBtn);
		waitForElement(allowSelectionBtn);
		waitForElement(denyBtn);
	}

	// Verify the switch buttons in the cookies pop-up
	public void verifyCookiesPopUpSwitchesDisplayed() {
		waitForElement(necessarySwitchtn);
		waitForElement(preferencesSwitchBtn);
		waitForElement(statisticsSwitchBtn);
		waitForElement(marketingSwitchBtn);
	}

	// Click on the selection button in the cookies pop-up
	public void selectCookies(String option) {
		if (option.equalsIgnoreCase("Allow All")) {
			click(allowAllBtn);
		} else if (option.equalsIgnoreCase("Allow Selection")) {
			click(allowSelectionBtn);
		} else if (option.equalsIgnoreCase("Deny")) {
			click(denyBtn);
		}
	}
	
	// Verify the necessary switch button in the cookies pop-up is disabled
	public void verifyNecessarySwitchDisabled() {
		waitForElement(necessarySwitchtn);
		Assert.assertFalse(necessarySwitchtn.isEnabled());
	}
	
	// Click on the show details link in the cookies pop-up
	public void clickShowDetailsLink() {
		waitForElement(showDetailsLink);
		click(showDetailsLink);
	}
	
	// Verify the cookies pop-up expanded details link is displayed
	public void verifyCookiesPopUpExpandedDetailsDisplayed() {
		waitForElement(cookiePopUpExpandedDetails);
		Assert.assertTrue(cookiePopUpExpandedDetails.isDisplayed());
	}
	
	// Verify whether the cookies pop-up is closed/disappeared
	public void verifyCookiesPopUpClosed() {
		waitForElementToDisappear(cookiesHeader);
	}
	
}
