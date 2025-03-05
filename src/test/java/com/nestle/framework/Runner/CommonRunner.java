package com.nestle.framework.Runner;

import org.junit.runner.RunWith;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/featurefiles/nestle.feature"},
		
		glue = {"com.nestle.framework.StepDefinition" , "com.nestle.framework.Hooks"},
		
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
				},		
		monochrome = true,
		dryRun = false
		)

public class CommonRunner extends AbstractTestNGCucumberTests {
//tags = "@test",
}


//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",