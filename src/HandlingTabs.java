import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.bcel.verifier.exc.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingTabs {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chrormeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(5000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight/2)");
		String Home =driver.getWindowHandle();
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.linkText("Contact Us")).sendKeys(selectLinkOpeninNewTab);
		driver.findElement(By.linkText("About Us")).sendKeys(selectLinkOpeninNewTab);
		Set<String> Windows = driver.getWindowHandles();
		Windows.remove(Home); 
		List<String> Newwindow = new ArrayList<>(Windows);
		driver.switchTo().window(Newwindow.get(0));
		Thread.sleep(10000);
		driver.switchTo().window(Newwindow.get(1));
		Thread.sleep(10000);
		for(String handle : driver.getWindowHandles()) {
	        if (!handle.equals(Home)) {
	            driver.switchTo().window(handle);
	            driver.close();
	        }
	    }
		driver.switchTo().window(Home);
		
			
		}

	}


