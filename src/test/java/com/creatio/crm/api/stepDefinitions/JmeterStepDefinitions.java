package com.creatio.crm.api.stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.jmeter.report.config.ConfigurationException;
import org.apache.jmeter.report.dashboard.GenerationException;

import com.creatio.crm.framework.api.commons.JMeterCommons;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JmeterStepDefinitions {
	
	static String JMeterFileName ;
	
	@When("The User load the Jmeter file {string}")
	public void the_user_load_the_jmeter_file(String fileName) {
		JMeterFileName = fileName;
	}

	@Then("The User should be able to run the JMeter file")
	public void the_user_should_be_able_to_run_the_j_meter_file() throws IOException, ConfigurationException, GenerationException {
		File outputFolder =new File(System.getProperty("user.dir") + "\\src\\test\\resources\\jmeter\\results");
		File jsonReportsPath =new File(System.getProperty("user.dir") + "\\report-output");
		File htmlreportsPath =new File(System.getProperty("user.dir") + "\\src\\test\\resources\\jmeter\\bin\\report-output");
		JMeterCommons.deleteDirectory(jsonReportsPath);
		JMeterCommons.deleteDirectory(htmlreportsPath);
		JMeterCommons.deleteDirectory(outputFolder);
	   JMeterCommons.runJMeterTestPlan(JMeterFileName);
	}


   
}
