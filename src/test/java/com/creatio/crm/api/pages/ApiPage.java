package com.creatio.crm.api.pages;

import org.json.JSONObject;

public class ApiPage {

	public static String createRepoRequestBody(String name, String description, boolean visibility) {
		JSONObject jo = new JSONObject();
		jo.put("name", name);
		jo.put("description", description);
		jo.put("private", visibility);
		return jo.toString();
	}
	
	public static String updateRepoRequestBody(boolean visibility) {
		JSONObject jo = new JSONObject();
		jo.put("private", visibility);
		return jo.toString();
	}

}
