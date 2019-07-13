import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenshotFailedCases {
 
		 static WebDriver driver;
		 @BeforeTest
		 public void BeforeTest() throws InterruptedException 
		 {
			 System.setProperty("webdriver.chrome.driver", "E:\\chrormeDriver\\chromedriver.exe");
	 	     driver = new ChromeDriver();
	 	     driver.get("https://www.amazon.in");
	 	     //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 	     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles");
	 	     driver.findElement(By.xpath("//input[@type='submit']")).click();
	 	     driver.findElement(By.xpath(".//*[@id='leftNavContainer']/ul[5]/div/li[2]/span/span/div/label/input")).click();
			Thread.sleep(500);
	 	     driver.getTitle();
		 }
		 @Test
		 public void Test() throws IOException 
		 {
			 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				// Code to copy the screenshot in the desired location
				FileUtils.copyFile(scrFile, new File("C:\\New folder\\google.jpg"));
		 }
		 @AfterTest
		 public void AfterTest() throws Exception {
		 Thread.sleep(200);	 
	     driver.quit();
		 }
}

