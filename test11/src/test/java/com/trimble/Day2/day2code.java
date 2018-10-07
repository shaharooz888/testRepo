package com.trimble.Day2;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class day2code {
	
	
	Response res;
	private int expectedSC;
	
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
    
    @When("^user hit the get request$")
	public void user_hit_the_get_request(){
		
		//Response res = 
		res = RestAssured.given().relaxedHTTPSValidation().
					when().get("https://ergast.com/api/f1/2017/circuits.json");


    }

}
