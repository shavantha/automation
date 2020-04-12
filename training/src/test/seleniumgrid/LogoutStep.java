package seleniumgrid;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogoutStep {

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("I am logged in")
    public void i_am_logged_in() {
        System.setProperty("webdriver.firefox.driver","/Users/shavanthaweerasinghe/projects/training/training");
        driver=new FirefoxDriver();
        driver.get("http://demo.guru99.com/test/newtours/login_sucess.php");
    }


    @When("I click on logout button")
    public void i_click_on_logout_button() {
        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")).click();
    }


    @Then("I should be logged out of the system")
    public void i_should_be_logged_out_of_the_system() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Welcome: Mercury Tours";
        Assert.assertEquals(expectedTitle,actualTitle);
        driver.quit();
    }

}
