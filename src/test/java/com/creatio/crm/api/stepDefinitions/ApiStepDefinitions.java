package com.creatio.crm.api.stepDefinitions;

import com.creatio.crm.api.pages.ApiPage;
import com.creatio.crm.framework.api.commons.ApiCommons;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiStepDefinitions {
	
	private String repositoryName;
	private String repositoryDescription;
	
	@Given("User sets the repository name as {string} and description as {string}")
	public void user_sets_the_repository_name_as_and_description_as(String name, String description) {
	    this.repositoryName = name;
	    this.repositoryDescription = description;	    
	}

	@When("User sends a {string} request to {string} To create the repository with visibility {string}")
	public void user_sends_a_request_to_to_create_the_repository_with_visibility(String requestType, String endPoint, String visibily) {
	    String requestBody = ApiPage.createRepoRequestBody(repositoryName, repositoryDescription, Boolean.parseBoolean(visibily));
	    ApiCommons.getResponse(requestType, endPoint, requestBody);
	}

	@Then("User should get the response code as {int}")
	public void user_should_get_the_response_code_as(Integer expCode) {
		ApiCommons.validateResponseCode(expCode);	    
	}

	@Then("User should get the response message as {string}")
	public void user_should_get_the_response_message_as(String expMessage) {
	    ApiCommons.validateStatusMessage(expMessage);	    
	}

	@Then("The response time should be less than {int} seconds")
	public void the_response_time_should_be_less_than_seconds(Integer expMaxResponseTime) {
		ApiCommons.validateResponseTime(expMaxResponseTime);	    
	}

	@Then("The response body should have {string} as {string}")
	public void the_response_body_should_have_as(String key, String value) {
		ApiCommons.validateResponseBody(key, value);	    
	}

	@When("User sends a {string} request to {string} to get the repository")
	public void user_sends_a_request_to_to_get_the_repository(String requestType, String endPoint) {
	    ApiCommons.getResponse(requestType, endPoint, null);	    
	}

	@When("User sends a {string} request to {string} to update repository visibility {string}")
	public void user_sends_a_request_to_to_update_repository_visibility(String requestType, String endPoint, String visibility) {
		String body =ApiPage.updateRepoRequestBody(Boolean.parseBoolean(visibility));
		ApiCommons.getResponse(requestType, endPoint, body);	    
	}
	
}