package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\Eclipse workspace\\nopCommerse_SeleniumCucumber\\Features\\LoginCommerce.feature",
				 glue = "stepDefinitions" ,	
				 dryRun = false, 
				 monochrome = true,
				 //tags= {"@ignore"},
				 plugin= { "pretty", "html:target/cucumber-htmlreport","json:target/cucumber-report.json" })

public class TestRunner {
	
	

}
