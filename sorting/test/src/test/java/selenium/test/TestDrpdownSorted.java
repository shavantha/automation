package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;


public class TestDrpdownSorted {
    @Test
    public void runTestOnDocker() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/shavanthaweerasinghe/projects/training/sorting/test/chromedriver");
        WebDriver driver = new ChromeDriver();


        driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");

        WebElement element = driver.findElement(By.xpath("//*[@id=\"animals\"]"));

        Select se = new Select(element);
        List<String> originalList = new ArrayList();
        for (WebElement e : se.getOptions()) {
            originalList.add(e.getText());
            System.out.println(">>>>>>>"+e.getText());
        }
        //----logic block starts
        List<String> tempList= originalList;
        Collections.sort(tempList);
        System.out.println(">>>>>>>"+tempList);
        Assert.assertEquals(tempList, originalList);


        //----logic ends starts
        driver.quit();
    }
    public static void main(String arg[])throws Exception{
        TestDrpdownSorted testDrpdownSorted =new TestDrpdownSorted();
        testDrpdownSorted.runTestOnDocker();

    }
}