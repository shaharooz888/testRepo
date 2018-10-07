package com.trimble.testing2;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/java/com/trimble/testing2/SheetFeature.feature"},
		glue = {"/src/test/resources/UpdatedJsonPost/Pot.json"},
				plugin={"pretty",
						"html:target/cucumber-htmlreport",
						"json:target/cucumber-report688.json",
						"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport1.html"
				}
		)
		
public class RunSecondScriptTest{
	
}