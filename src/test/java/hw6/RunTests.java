package hw6;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/hw6/features"
)
public class RunTests extends AbstractTestNGCucumberTests {
}
