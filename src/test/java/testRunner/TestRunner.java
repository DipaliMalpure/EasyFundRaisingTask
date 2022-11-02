package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        glue = {"stepsDefination"},plugin = {"pretty","html:target/HtmlReports/index.html"})
public class TestRunner {

}
