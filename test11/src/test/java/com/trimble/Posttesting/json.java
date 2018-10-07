package com.trimble.Posttesting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.JSONObject;
import cucumber.api.java.en.Given;

public class json {
	
	Response resp;
	public void abc() {
	     
	    System.out.println("Hello World");
	    Response res = RestAssured.given().when().get("www.google.com");
	    int i = res.getStatusCode();
	    System.out.println("code ="+i);
	}
	    

	@Given("^user hit the post request with \"([^\"]*)\" name$")
	public void user_hit_the_post_request_with_json_data(String username) throws IOException{
		
		//Read data from file
		String data = ""; 
	    data = new String(Files.readAllBytes(Paths.get("/Cucumber_Trimble/src/test/resources/UpdatedJsonPost/Pot.json"))); 
	    System.out.println("json in String ==== " +data);
	    
	    //Update the data
	    JSONObject object=new JSONObject(data);
	    object.put("name", "Anil");
	    String newJsonStr = object.toString();
	    System.out.println("json in String ==== " +newJsonStr);
	    
	    //Do POST request
	    resp = RestAssured.given().accept(ContentType.JSON).relaxedHTTPSValidation().
				when().body(newJsonStr).post("https://reqres.in/api/users");
	}

	}


