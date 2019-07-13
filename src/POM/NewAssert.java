package POM;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;


public class NewAssert {
@Test
public void test1() {
	    System.setProperty("webdriver.chrome.driver", "E:\\chrormeDriver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://www.google.com");
	   // String expextedTitle = "Google";
	   //Assert.assertTrue("Title Match", expextedTitle.equals(driver.getTitle()));
  }
}
