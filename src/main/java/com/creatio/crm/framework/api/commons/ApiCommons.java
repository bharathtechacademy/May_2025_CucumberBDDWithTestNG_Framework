package com.creatio.crm.framework.api.commons;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.creatio.crm.framework.utilities.PropUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiCommons {
	
	public static Response response = null;
	public static Properties prop = PropUtil.readData("Config.properties");
	
	//method to get the response
	public static void getResponse(String requestType, String endpoint, String requestBody) {
		RestAssured.baseURI =prop.getProperty("api_base_url");
		String token = prop.getProperty("api_token");
		requestType= requestType.toUpperCase();
		if (requestType.equalsIgnoreCase("GET")) {
			response = given().headers("Authorization", token).headers("Accept", "application/vnd.github+json").when().get(endpoint);
		} else if (requestType.equalsIgnoreCase("POST")) {
			response = given().headers("Authorization", token).headers("Accept", "application/vnd.github+json").body(requestBody).when().post(endpoint);
		} else if (requestType.equalsIgnoreCase("PUT")) {
			response = given().headers("Authorization", token).headers("Accept", "application/vnd.github+json").body(requestBody).when().put(endpoint);
		} else if (requestType.equalsIgnoreCase("PATCH")) {
			response = given().headers("Authorization", token).headers("Accept", "application/vnd.github+json").body(requestBody).when().patch(endpoint);
		}else if (requestType.equalsIgnoreCase("DELETE")) {
			response = given().headers("Authorization", token).headers("Accept", "application/vnd.github+json").when().delete(endpoint);
		}
		System.out.println("Response: " + response.asPrettyString());
		wait(3);
	}
	
	// method to validate the response code
	public static void validateResponseCode(int expectedCode) {
		int actualCode = response.getStatusCode();
		Assert.assertEquals(actualCode, expectedCode, "Response code does not match expected code");
	}
	
	// method to validate the status line
	public static void validateStatusMessage(String expStatusMessage) {
		String actualStatusLine = response.getStatusLine();
		Assert.assertTrue(actualStatusLine.contains(expStatusMessage), "Status line does not match expected status line");
	}
	
	// method to validate the response time
	public static void validateResponseTime(long maxResponseTime) {
		long actualResponseTime = response.getTimeIn(TimeUnit.SECONDS);
		Assert.assertTrue(actualResponseTime <= maxResponseTime, "Response time exceeds the maximum allowed time");
	}
	
	// method to validate the response body
	public static void validateResponseBody(String key, String expectedValue) {
		String actualValue = response.jsonPath().getString(key);
		Assert.assertEquals(actualValue, expectedValue, "Response body does not contain expected value for key: " + key);
	}
	
	// method to validate the response header
	public static void validateResponseHeader(String headerName, String expectedValue) {
		String actualValue = response.getHeader(headerName);
		Assert.assertEquals(actualValue, expectedValue, "Response header does not contain expected value for header: " + headerName);
	}
	
	//method to wait for some time
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}