package stepsDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjectPages.LandingPage;
import pageObjectPages.SearchPage;

import java.time.Duration;

public class SimpleSearchStepDef {
    WebDriver driver;
    SearchPage searchPage;

    LandingPage landingPage;
    String searchString;

    @Given("User open the website")
    public void user_open_the_website() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        searchPage = new SearchPage(driver);
        landingPage=new LandingPage(driver);
        landingPage.openURL();
    }
    @And("Go to the link find cause")
    public void go_to_the_link_find_cause() {
       landingPage.setFindCause();
    }

    @When("^user types (.*) and select the third cause if exists$")
    public void user_type_charector_in_the_search_field_and_select_third_cause(String searchString) {
        searchPage.setSearchBox(searchString);
    }

    @Then("user will be given a confirmation message")
    public void confirm_with_the_message()
    {
        driver.quit();
    }


}
