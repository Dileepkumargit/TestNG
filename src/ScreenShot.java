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

public class ScreenShot {
	WebDriver driver;
	@BeforeTest
	public void setUp() throws Exception {
		 System.setProperty("webdriver.chrome.driver", "E:\\chrormeDriver\\chromedriver.exe");
 	     driver = new ChromeDriver();
 	     driver.get("https://www.amazon.in");
 	     //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 	     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("shirts");
 	     driver.findElement(By.xpath("//input[@type='submit']")).click();
 	     
	
	}
	@AfterTest
	public void tearDown() throws Exception {
	driver.quit();
	}

	@Test
	public void test() throws IOException {
	// Code to capture the screenshot
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	// Code to copy the screenshot in the desired location
	FileUtils.copyFile(scrFile, new File("C:\\CaptureScreenshot\\google.jpg"));
	}
}
