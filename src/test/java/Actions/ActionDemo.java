package Actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType; 
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.BasicConfigurator;

public class ActionDemo{

	  // private static  Logger log;

	   @Test
           public void testLink(){
		   BasicConfigurator.configure();

		   //log=LogManager.getLogger(ActionDemo.class.getName());

           System.setProperty("webdriver.chrome.driver","/home/shavantha/projects/automation/training/driver/chromedriver");
	   //To accept insecure certs
	   DesiredCapabilities dc=new DesiredCapabilities().chrome();
	   dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
	   ChromeOptions chrOp=new ChromeOptions();
	   chrOp.addArguments("--headless");
	   chrOp.addArguments("--disable-gpu");
	   chrOp.merge(dc);
	   WebDriver driver =new ChromeDriver(chrOp);
	   //To maximize window
	   driver.manage().window().maximize();
	   //To delete the cookies
	   driver.manage().deleteAllCookies();
	   driver.get("https://www.amazon.com");
	   Actions actions =new Actions(driver);
	   WebElement move =driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
           actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys(
           		"selenium").build().perform();
           actions.moveToElement(move).build().perform();
           //log.debug("DEBUG LOG>>>");
	   // Take screenshot and store as a file format
           File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   try{
           FileUtils.copyFile(src, new File("/home/shavantha/projects/automation/training/screenshot/image.png"));
	   }catch(IOException e){}
	         driver.quit();
	}
}
