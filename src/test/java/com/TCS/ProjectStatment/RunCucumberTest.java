package com.TCS.ProjectStatment;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty","html:target/cucumber-report.html"},
		features="src\\test\\resources\\com\\TCS\\ProjectStatment",
		//tags  ="@UrlValidation, ,@Navigation, @loginModule, @mobile", 
		glue= {"stepDefinitions"},
		//dryRun = true,
		monochrome = true
		)




public class RunCucumberTest {

}
