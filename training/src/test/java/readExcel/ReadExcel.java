package readExcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadExcel {

    WebDriver driver;
    WebDriverWait wait;
    WebElement searchButton;
    String URL, name;

    @BeforeTest
    public void setup() throws IOException {


            System.setProperty("webdriver.firefox.driver", "/Users/shavanthaweerasinghe/projects/training/training/geckodriver");
            driver = new FirefoxDriver();

            String filePath = "/Users/shavanthaweerasinghe/projects/training/training";
            String fileName = "student.xlsx";
            String sheetName = "Student";


            File file = new File(filePath + "//" + fileName);
            FileInputStream inputStream = new FileInputStream(file);

            Workbook studentInfo = null;

            //Find the file extension by splitting file name in substring  and getting only extension name

            String fileExtensionName = fileName.substring(fileName.indexOf("."));

            //Check condition if the file is xlsx file

            if (fileExtensionName.equals(".xlsx")) {

                //If it is xlsx file then create object of XSSFWorkbook class

                studentInfo = new XSSFWorkbook(inputStream);

            }

            //Read sheet inside the workbook by its name

            Sheet xlsSheet = studentInfo.getSheet(sheetName);

             URL=xlsSheet.getRow(1).getCell(0).getStringCellValue();
             name=xlsSheet.getRow(1).getCell(1).getStringCellValue();

        }

        @Test
        public void testSearch () throws java.lang.IllegalMonitorStateException, NullPointerException
        {
            driver.get(URL);
            driver.findElement(By.name("q")).sendKeys(name);
            wait = new WebDriverWait(driver, 20);
            searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/div[3]/center/input[1]")));
            searchButton.click();

        }

        @AfterTest
        public void tearDown () {
            driver.quit();

        }


    }
