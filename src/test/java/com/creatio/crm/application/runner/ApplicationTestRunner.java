package com.creatio.crm.application.runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="Features",
		glue={"com.creatio.crm.framework.base","com.creatio.crm.application.stepDefinitions"},
		plugin={"pretty", "html:Reports/AutomationTestResults.html"}
	//	,tags="@Regression"
		)

public class ApplicationTestRunner extends AbstractTestNGCucumberTests {

	@Test
	public void runApplicationTests() {
		System.out.println("Running Application Tests...");
	}

}
