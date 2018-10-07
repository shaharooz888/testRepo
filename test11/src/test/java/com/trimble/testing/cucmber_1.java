package com.trimble.testing;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class cucmber_1 {
	
	
	Response res;
	private int expectedSC;
		
     @Given("Launching Google")
     
     public void abc() {
     
    System.out.println("Hello World");
    Response res = RestAssured.given().when().get("www.google.com");
    int i = res.getStatusCode();
    System.out.println("code ="+i);
    
    
	}
     
     @Given("user start the rest asured test")
     public void user_start_the_rest_assured_test() {
    	 System.out.println("Hello World");
    	 res = RestAssured.given().when().get("www.google.com");
     }
     
     @Given("user checks 200 the status code")
     public void user_checks_the_status_code() {
    	 int i = res.getStatusCode();
    	 Assert.assertTrue(expectedSC==i);
    	 System.out.println();
     }
     
     

}
