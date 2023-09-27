package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
    features = "src/test/java/features/cartlogin.feature",
    glue = "stepDefinitions"
   
)
public class runner {

}
