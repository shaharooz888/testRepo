package com.trimble.testing2;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class cucmber_2 {
	
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
     
     @When("^user hit the get request$")
 	public void user_hit_the_get_request(){
 		
 		//Response res = 
 		res = RestAssured.given().relaxedHTTPSValidation().
 					when().get("https://ergast.com/api/f1/2017/circuits.json");
 		
 		//print response in string
 		String respString = res.asString();
 		System.out.println(respString);
 		
 		//get all headers
 		Headers heds = res.getHeaders();
 		System.out.println(heds);
 		
 	}
     
     @Then("^user checks the count or size$")
 	public void user_checks_the_count_or_size(){
 		
 		res.then().assertThat().body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
 		
 		String limitValue = res.getBody().jsonPath().getString("MRData.limit");
 		Assert.assertEquals("30", limitValue);
 		
 		
 		//verify the size
 		res.then().assertThat().body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
 	}

	private ResponseAwareMatcher<Response> hasSize(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Then("^user checks at path \"([^\"])\" with the \"([^\"])\" value$")
	public void user_checks_at_path_with_the_value(String path, String expValue){
		String actualCircuitValue = res.getBody().jsonPath().getString(path);
		Assert.assertEquals(expValue, actualCircuitValue);
	}
     

}
