package tests;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
//		dryRun=true, // checks if code for feature exists
		monochrome=true,
		features = "src/feature",
		glue={"stepdefinition"}
		)
public class TestRun {

}
