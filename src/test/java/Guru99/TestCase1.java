package Guru99;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static junit.framework.TestCase.assertEquals;

public class TestCase1 {
    public int scc = 0;

    WebDriver browser = new ChromeDriver();
    @Given("^I am on website")
    public void openBrowser(){
        browser.navigate().to("http://live.guru99.com/index.php/n");
    }
    @When("^I verify the title of the page")
    public void Verify(){
        String actualTitle = browser.getTitle();
        String expectedTitle = "Home page";
        assertEquals(actualTitle, expectedTitle);
    }
    @When("^I click on Mobile Menu")
    public void Mobile(){
        browser.findElement(By.xpath("//li[contains(@class, 'level0')]/a")).click();
    }
    @Then("^I verify the title of the page")
    public void Title(){
        String pageTitle = browser.getTitle();
        String expectedPageTitle = "Mobile";
        assertEquals(pageTitle, expectedPageTitle);
    }
    @When("^I select the 'SORT BY' dropdown by name")
    public void Select(){
        Select SortBy = new Select(browser.findElement(By.cssSelector("select[title=\"Sort By\"]")));
        SortBy.selectByVisibleText("Name");
    }
    @Then("^products are sorted by name")
    public void Name(){
        scc = (scc + 1);
        File scrFile = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);
        String png = ("C:\\Guru99\\Day1\\Mobile Products are sorted" + scc + ".png");
        File DestFile = new File(png);
        try {
            FileUtils.copyFile(scrFile, DestFile);
        } catch (Exception e) {
        }
    }
}


