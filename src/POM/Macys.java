package POM;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Macys {
	@Test
	public void macys() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\chrormeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.mcom-036.tbe.zeus.fds.com/");
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		MacysHome Homepage = new MacysHome(driver);
		Homepage.gotoUSsite();
		Homepage.searchfor();
		Homepage.clickBrand();
		Homepage.choseBrand();
		Homepage.pickitem();
		Thread.sleep(3000);
		Homepage.SelectSize();
		Homepage.AddtoList();
	}

}
