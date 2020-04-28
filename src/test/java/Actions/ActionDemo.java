package Actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.openqa.selenium.By;

public class ActionDemo{


	   @Test
           public void testLink(){
           System.setProperty("webdriver.chrome.driver","/home/shavantha/projects/automation/training/driver/chromedriver");
	   WebDriver driver =new ChromeDriver();
	   driver.get("https://www.amazon.com");
	   Actions actions =new Actions(driver);
	   WebElement move =driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
           actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys(
           		"selenium").build().perform();
           actions.moveToElement(move).build().perform();
	}
}
