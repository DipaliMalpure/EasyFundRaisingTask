package pageObjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    WebDriver driver;

    By findCause = By.xpath("//*[@id=\"__next\"]/div[3]/header/div/div/div[2]/nav/div[2]/a");
    By coockiesPopup = By.xpath("//*[@id=\"cookieConsentPopup\"]/button");

    /**
     * This is Constructor
     *
     * @param driver
     */
    public LandingPage(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * This is method for open the Website
     */
    public void openURL() {
        driver.get("https://www.easyfundraising.org.uk/ ");
    }

    /**
     * This is method for go to the link ‘Find a Cause’ on the top of the page
     */
    public void setFindCause() {
        driver.findElement(findCause).click();
        driver.findElement(coockiesPopup).click();
    }
}
