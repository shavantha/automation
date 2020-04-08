package ToolsQA;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;


public class ExtentDemo {
    static ExtentTest test;
    static ExtentReports report;

    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
        test = report.startTest("ExtentDemo");
    }

    @Test
    public void extentReportsDemo()
    {
        System.setProperty("webdriver.gecko.drive", "/Users/shavanthaweerasinghe/projects/training/DemoMavenProject/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.lk");


        if(driver.getTitle().equals("selenium - Google Search"))
        {
            test.log(LogStatus.PASS, "Navigated to the specified URL");
        }
        else
        {
            test.log(LogStatus.FAIL, "Test Failed");
        }

        driver.findElement(By.name("q")).sendKeys("Selenium");
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));
        driver.findElement(By.name("btnK")).click();


        String searchValue=driver.findElement(By.xpath("/html/body/div[7]/div[3]/div[8]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div[1]/a/h3")).getText();

        WebDriverWait wait2 = new WebDriverWait(driver,30);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div[3]/div[8]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div[1]/a/h3")));

        if(searchValue.equals("Selenium"))
        {
            test.log(LogStatus.PASS, "Search value found");
        }
        else
        {
            test.log(LogStatus.FAIL, "Test Failed");
        }

        driver.close();
        driver.quit();
    }
    @AfterClass
    public static void endTest()
    {
        report.endTest(test);
        report.flush();
    }

}
