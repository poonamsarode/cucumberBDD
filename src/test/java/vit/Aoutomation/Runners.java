package vit.Aoutomation;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		glue = "vit.Aoutomation.stepdefs",
		tags = "",
		plugin =  {"pretty", // to generate reports
	            "html:target/html/htmlreport.html",
	            "json:target/json/file.json",
	            },
	        publish=true,
	        dryRun=false // to tell whether to test run(true) or actual run(false)
	
		)


public class Runners {

}
