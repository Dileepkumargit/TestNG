import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.classfile.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

public class RandomList {
	WebDriver driver;
	@Test
	public void macys() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chrormeDriver\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("http://www.mcom-087.tbe.zeus.fds.com/shop/featured/pants");
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		driver.findElement(By.id("href_goToUSSite")).click();
		Thread.sleep(200);
		driver.findElement(By.id("globalSearchInputField")).sendKeys("shorts");
		driver.findElement(By.id("searchSubmit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"BRAND\"]/h2")).click();
		List<WebElement> options = driver.findElements(By.xpath("//li[@id='BRAND']//span[@class='item']"));
		Random rand = new Random();
		int list= rand.nextInt(options.size());
		options.get(list).click();
		driver.findElement(By.id("435868653")).click();
	 

	}
	@AfterMethod
	 public void screenshot(ITestResult result) throws IOException {
		if(ITestResult.FAILURE== result.getStatus()) {
			try 
			{
			// Create refernce of TakesScreenshot
			TakesScreenshot ts=(TakesScreenshot)driver;
			 
			// Call method to capture screenshot
			File source=ts.getScreenshotAs(OutputType.FILE);
			 
			// Copy files to specific location here it will save all screenshot in our project home directory and
			// result.getName() will return name of test case so that screenshot name will be same
			FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));
			 
			System.out.println("Screenshot taken");
			} 
			catch (Exception e)
			{
			 
			System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
			  
		}
		
	}
	

}
