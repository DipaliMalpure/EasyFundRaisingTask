package stepsDefination;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/amolmalpure/IdeaProjects/SprignApiTestNew/EasyFundRaisingTask/src/test/resources/features/",
        glue = {"stepsDefination"},plugin = {"pretty","html:target/HtmlReports/index.html"})
public class TestRunner {

}
