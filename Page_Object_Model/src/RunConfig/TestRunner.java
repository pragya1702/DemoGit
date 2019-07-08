package RunConfig;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Featurefiles/login.feature"
		,glue={"StepDefinitions.login_Steps"}
		,tags={"@login"}
		)


public class TestRunner {

}
