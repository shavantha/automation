package selenium.test;

import java.util.ArrayList;
import java.util.Collections;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VerifyDropDownSortedOptions {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/shavanthaweerasinghe/projects/training/sorting/test/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement element = driver.findElement(By.xpath("//*[@id=\"animals\"]"));
        Select se = new Select(element);

        ArrayList originalList = new ArrayList();

        for (WebElement e : se.getOptions()) {
            originalList.add(e.getText());
        }
        System.out.println("originalList:" + originalList);

        ArrayList tempList = originalList;
        Collections.sort(tempList); // When you change one list, it changes the other list as well.

        System.out.println("originalList:" + originalList);
        System.out.println("tempList:" + tempList);

  /*So the test gets pass all the time because the sequence in the originalList
  and tempList is going to be same.
  If you are following above process then your test never fails, because When
  you change one list, it changes the other list as well.*/

        if (originalList == tempList) {
            System.out.println("Dropdown sorted");
        } else {
            System.out.println("Dropdown NOT sorted");
        }
        driver.quit();
    }
}