package com.trimble.testing;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty",
		"html:target/cucumber-htmlreport",
		"json:target/cucumber-report611.json",
		"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport1.html"
})
public class RunFirstScriptTest{
	
}


