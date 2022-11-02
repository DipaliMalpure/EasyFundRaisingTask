package pageObjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage
{
    WebDriver driver;

    By searchBox = By.xpath("//*[@id=\"sagc-hero-search-input\"]");

    By pathForSelectingThirdOption =By.xpath("//*[@id=\"sagc-hero-search-input-auto-suggest\"]/li[3]/button[1]");
    By pathForSearchButton =By.xpath("//*[@id=\"sagc-hero-search-submit\"]");

    /**
     * This is constructor
     * @param driver
     */
    public SearchPage(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * This is method for enter 3 characters in the search field box
     * @param searchString
     */

    public void setSearchBox(String searchString)
    {
        driver.findElement(searchBox).sendKeys(searchString);
        List<WebElement> l = driver.findElements(pathForSelectingThirdOption);
        if(l.size() == 1 ){
            System.out.println("Element found");
            setSelect_Third_Option();
            setCLick_Search_Button();
            //displayConfirmationMessage();
        }else{
            System.out.println("Element not found");
        }
    }

    /**
     * This is method for Confirm with a message that the selected 3rd Cause exists in the Search results
     */
    private void displayConfirmationMessage()  {
        JavascriptExecutor executer = (JavascriptExecutor) driver;
        executer.executeScript("confirm('Element selected')");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is method for Select the 3rd cause from the suggestion list
     */

    public void setSelect_Third_Option()
    {
        driver.findElement(pathForSelectingThirdOption).click();

    }

    /**
     * This is method for Click on Search cause
     */
    public void setCLick_Search_Button()
    {

        driver.findElement(pathForSearchButton).click();
    }
}
