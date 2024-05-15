package stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features/JobSearchSortedResults.feature", 
		glue= {"stepdefinitions"}, 
		monochrome = true,  
		plugin = { "pretty",  "html:Reports/cucumber-pretty" },
		tags = "@firefox or @chrome"
)
public class TestRunner {

}
