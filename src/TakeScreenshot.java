import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

public class TakeScreenshot {
	static WebDriver driver;
	@Test
	public static void openbrowser() throws AWTException, InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "E:\\chrormeDriver\\chromedriver.exe");
	     	driver = new ChromeDriver();
	     	driver.get("https://www.abhibus.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.id("AccLogin")).click();
			driver.findElement(By.name("EmailID")).sendKeys("thupatidileep@gmail.com");
			driver.findElement(By.id("LoginPassword")).sendKeys("dileep335");
			driver.findElement(By.id("SignINAjx")).click();
			Thread.sleep(200);
			Robot R = new Robot();
			R.keyPress(KeyEvent.VK_ESCAPE);
			Thread.sleep(200);
	     
	}
	@AfterTest
	public void Screenshot(TestResult result) {
		if(TestResult.SUCCESS == result.getStatus())
		{
		try
			{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			driver.getPageSource();
			FileUtils.copyFile(scrFile, new File("C:\\CaptureScreenshot\\"));
			
			}
		catch(Exception e)
			{
			System.out.println("Successfully captured a screenshot");
			}
		}
		
		}
	 

}
