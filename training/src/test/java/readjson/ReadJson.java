package readjson;

import java.io.IOException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ReadJson {
    WebDriver driver;
    WebDriverWait wait;
    WebElement searchButton;
    String url,name,batch;
    int rollNo;
    JSONParser parser=new JSONParser();


    @BeforeTest
    public void setup() throws FileNotFoundException, IOException, ParseException
    {
        System.setProperty("webdriver.gecko.driver", "/Users/shavanthaweerasinghe/projects/training/training/grid/geckodriver");
        Object obj = parser.parse(new FileReader("/Users/shavanthaweerasinghe/projects/training/training/student.json"));


        JSONObject jsonObject = (JSONObject) obj;
        url = (String) jsonObject.get("url");
        name = (String) jsonObject.get("name");
        batch = (String) jsonObject.get("batch");
        //rollNo = (Integer) jsonObject.get("rollNumber");

        driver = new FirefoxDriver();
        driver.get(url);

    }

    @Test
    public void testSearch() throws java.lang.IllegalMonitorStateException,NullPointerException
    {

        driver.findElement(By.name("q")).sendKeys(name);
        wait=new WebDriverWait(driver, 20);
        searchButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/div[3]/center/input[1]")));
        searchButton.click();


        String webTitle = driver.getTitle();

    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();

    }
}
