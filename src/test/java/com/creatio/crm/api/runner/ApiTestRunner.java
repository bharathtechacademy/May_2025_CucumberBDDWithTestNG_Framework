package com.creatio.crm.api.runner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="ApiFeatures",
		glue={"com.creatio.crm.api.stepDefinitions"},
		plugin={"pretty", "html:Reports/AutomationReport.html"}
	//	,tags="@Regression"
		)

public class ApiTestRunner extends AbstractTestNGCucumberTests {

	@Test
	public void runApplicationTests() {
		System.out.println("Running API Functional Tests...");
	}

}
