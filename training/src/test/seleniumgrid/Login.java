package seleniumgrid;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;


public class Login {

    private WebDriver driver;
    private WebDriverWait wait;
    private static String nodeURL,baseURL;
    private static String path="/Users/shavanthaweerasinghe/projects/training/training/grid/geckodriver";

    @Given("I am in the login page of the newtours application")
    public void i_am_in_the_login_page_of_the_newtours_application() throws java.net.MalformedURLException
    {

        baseURL="http://demo.guru99.com/test/newtours/index.php";
        nodeURL="http://localhost:4444/wd/hub";

        DesiredCapabilities capabilities =DesiredCapabilities.firefox();
        capabilities.setBrowserName("firefox");
        capabilities.setPlatform(Platform.MAC);

        driver = new RemoteWebDriver(new URL(nodeURL),capabilities);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @When("I enter valid {string} and {string}")
    public void i_enter_valid_and(String username, String password) {
        driver.findElement(By.name("userName")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/" +
                "table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input")).click();
    }

    @Then("I should be taken to the overview page")
    public void i_should_be_taken_to_the_overview_page() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Login: Mercury Tours";
        Assert.assertEquals(expectedTitle,actualTitle);
        driver.close();
    }
}
