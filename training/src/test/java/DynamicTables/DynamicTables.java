package DynamicTables;

import java.text.ParseException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicTables {
    WebDriver driver;

       @BeforeTest
        public void setup() throws ParseException {

           System.setProperty("webdriver.gecko.driver", "/Users/shavanthaweerasinghe/projects/training/training/grid/geckodriver");
           driver = new FirefoxDriver();
       }

       @Test
       public void testTables(){
            driver.get("http://demo.guru99.com/test/web-table-element.php");
            //No.of Columns
            List  col = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
            System.out.println("No of cols are : " +col.size());
            //No.of rows
            List  rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
            System.out.println("No of rows are : " + rows.size());

           testExtractValue();

        }


        public void testExtractValue(){
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebElement baseTable = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/table"));

            //To find third row of table
            WebElement tableRow = baseTable.findElement(By.xpath("/html/body/div/div[3]/div[1]/table/tbody/tr[3]/td[1]/a"));
            String rowtext = tableRow.getText();
            System.out.println("Third row of table : "+rowtext);

            //to get 3rd row's 2nd column data
            WebElement cellIneed = tableRow.findElement(By.xpath("/html/body/div/div[3]/div[1]/table/tbody/tr[3]/td[3]"));
            String valueIneed = cellIneed.getText();
            System.out.println("Cell value is : " + valueIneed);

        }

        @AfterTest
        public void tearDown(){
            driver.quit();
        }
}
