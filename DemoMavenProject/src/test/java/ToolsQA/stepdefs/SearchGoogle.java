package ToolsQA.stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchGoogle {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I launch Chrome browser")
    public void i_launch_Chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "/Users/shavanthaweerasinghe/projects/training/DemoMavenProject/chromedriver");
        WebDriver driver = new FirefoxDriver();

    }

    @When("I open Google Homepage")
    public void i_open_Google_Homepage() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.google.lk");
    }

    @Then("I verify that the page displays search text box")
    public void i_verify_that_the_page_displays_search_text_box() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.name("q")).sendKeys("Selenium");
        wait = new WebDriverWait(driver,30);
    }

    @Then("the page displays Google Search button")
    public void the_page_displays_Google_Search_button() {
        // Write code here that turns the phrase above into concrete actions
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));
        driver.findElement(By.name("btnK"));
    }


    @Then("the page displays Im Feeling Lucky button")
    public void the_page_displays_Im_Feeling_Lucky_button() {
        // Write code here that turns the phrase above into concrete actions
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));
        driver.findElement(By.name("btnI"));
    }

}
