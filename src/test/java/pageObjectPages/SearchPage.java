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

    public boolean setSearchBox(String searchString)
    {
        boolean elementPresent;
        driver.findElement(searchBox).sendKeys(searchString);
        List<WebElement> l = driver.findElements(pathForSelectingThirdOption);
        if(l.size() == 1 ){
            setSelect_Third_Option();
            setClick_Search_Button();
            elementPresent = true;
        }else{
            elementPresent = false;
        }
        return elementPresent;
    }

    /**
     * This is method for Confirm with a message that the selected 3rd Cause exists in the Search results
     */
    public void displayConfirmationMessage(String message)  {
        JavascriptExecutor executer = (JavascriptExecutor) driver;
        String alretString = "alert('"+message+"')";
        executer.executeScript(alretString);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is method for Select the 3rd cause from the suggestion list if exists
     */

    public void setSelect_Third_Option()
    {
        driver.findElement(pathForSelectingThirdOption).click();
    }

    /**
     * This is method for Click on Search cause
     */
    public void setClick_Search_Button()
    {
        driver.findElement(pathForSearchButton).click();
    }
}
