package POM;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.net.telnet.WindowSizeOptionHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class dummy {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chrormeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.mcom-036.tbe.zeus.fds.com/shop/product/first-impressions-baby-girls-eyelet-cotton-shorts-created-for-macys?ID=7785147&CategoryID=63015&isDlp=true");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String source=driver.getPageSource();
		System.out.println(source);
		String dilip = driver.getWindowHandle();
		System.out.println(dilip);
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		driver.findElement(By.linkText("Help & FAQs")).sendKeys(selectLinkOpeninNewTab);
		
		Set<String> windows =  driver.getWindowHandles();
		windows.remove(dilip);
		List<String> myWindows = new ArrayList<>(windows); 
		driver.switchTo().window(myWindows.get(0));
		Thread.sleep(10000l);
		driver.switchTo().window(dilip);
		
		
		
		driver.findElement(By.xpath("//a[@class='view-more-sizes-link']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//li[@class='swatch-itm large'])[2]"));
		Select size = new Select(driver.findElement(By.xpath("(//li[@class='swatch-itm large'])")));
		size.selectByIndex(2);
		
		
		//action.click(driver.findElement(By.xpath("(//li[@class='swatch-itm large'])[2]"))).perform();
		

	}

}
