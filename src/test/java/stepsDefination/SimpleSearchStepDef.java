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
    boolean elementPresent;
    /**
     * This method initializes the web drivers & then passes the reference of it to page object models
     */
    @Given("^User opens the website$")
    public void user_open_the_website() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        searchPage = new SearchPage(driver);
        landingPage = new LandingPage(driver);
        landingPage.openURL();
    }

    /**
     * This method handles the link "Find a Cause" on webpage
     */
    @And("^Go to the link find a cause$")
    public void go_to_the_link_find_cause() {
        landingPage.setFindCause();
    }

    @When("^user enters the (.*) and select the third cause if exists$")
    public void user_type_charector_in_the_search_field_and_select_third_cause(String searchString) {
        elementPresent = searchPage.setSearchBox(searchString);
    }

    @Then("^user will be given a confirmation message$")
    public void confirm_with_the_message() {
        if(elementPresent) {
            searchPage.displayConfirmationMessage("Element found & selected");
        }else{
            searchPage.displayConfirmationMessage("Element not found");
        }
        driver.quit();
    }

}
