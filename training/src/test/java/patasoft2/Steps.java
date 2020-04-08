package patasoft2;

import io.cucumber.core.gherkin.vintage.internal.gherkin.ast.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class Steps {

    private WebDriver driver;
    private WebDriverWait wait;


    @Given("I am in the login page of the para bank application")
    public void i_am_in_the_login_page_of_the_para_bank_application() {


        System.setProperty("webdriver.firefox.driver","/Users/shavanthaweerasinghe/projects/training/training\n");
        driver=new FirefoxDriver();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter valid credentials")
    public void i_enter_valid_crentials(DataTable dt) {
      /*  List<String> list = dt.asList(String.class);

        driver.findElement(By.name("username")).sendKeys(list.get(0));
        driver.findElement(By.name("password")).sendKeys(list.get(1));
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input")).click();*/
    }

    @Then("I should be taken to the overview page")
    public void i_should_be_taken_to_the_overview_page() {

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/h1")).isDisplayed();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[8]/a")).click();
        driver.quit();
    }
}
