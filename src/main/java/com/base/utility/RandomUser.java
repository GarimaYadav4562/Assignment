package com.base.utility;

import org.apache.log4j.Logger;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RandomUser {
	static Logger log = Logger.getLogger(RandomUser.class);
	
	public static User generateRandomeUser(int no_Of_Users) {
		log.info("Making an API call to get user details...");
		String baseUrl = "https://randomuser.me";
		RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        Response response = request
        		.queryParam("results",no_Of_Users)
        		.get("/api");
        System.out.println(response.getBody());
        Assert.assertEquals(200, response.getStatusCode());
        User user = response.getBody().as(User.class);
        return user;
	}
}


