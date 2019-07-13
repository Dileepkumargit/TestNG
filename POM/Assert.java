package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class N {
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "E:\\chrormeDriver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		String expectedTitle = "Amazon";
		//Assert assert = new Assert();
		Assert.assertTrue("Title does not match", expectedTitle(driver.getTitle()));
  }
}
