package com.creatio.crm.api.runner;


import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="PerformanceTestFeatures",
		glue={"com.creatio.crm.api.stepDefinitions"},
		plugin={"pretty", "html:Reports/AutomationReport.html"}
		)

public class LoadTestRunner extends AbstractTestNGCucumberTests {

	@Test
	public void runApplicationTests() {
		System.out.println("Running API Load Tests...");
	}

}
