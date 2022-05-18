package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions
(
		features="src/test/resources/features/WebUI",
		glue= {"stepdefinitions/WebUI","myhooks"},
		monochrome=true,
		plugin = {"pretty"},
		publish=true,
		tags="@WebTest"
		
		
)
public class TestRunner_Web {
	
}
