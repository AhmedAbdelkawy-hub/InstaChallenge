package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestPase;

@CucumberOptions(plugin = {"pretty","html:target/cucumber-html-report"}
,features = "src/test/java/features",
glue = {"steps"}
)


public class TestRunner extends TestPase{

}
