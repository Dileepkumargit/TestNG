package POM;



import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MacysHome {
	WebDriver driver;
	
	
	By gotoUSsite = By.id("href_goToUSSite");
	By searchfor  = By.id("globalSearchInputField");
	By clickBrand = By.xpath("//*[@id=\"GENDER\"]/h2");
	By choseBrand = By.xpath("//li[@id='GENDER']//span[@class='item']");
	By pickitem   = By.xpath("//li[@class='small-6 medium-4 large-3 cell productThumbnailItem']");
	By SelectSize = By.xpath("(//li[@class='swatch-itm'])[2]");
	By AddtoList  = By.xpath("//button[@class='secondary expanded']");
	
	
	public  MacysHome(WebDriver driver) throws InterruptedException
		{
			this.driver =driver;
			Thread.sleep(5000);
		}
	public void gotoUSsite()
	{
		driver.findElement(By.id("closeButton")).click();
		driver.findElement(gotoUSsite).click();
	}
	public void searchfor()
	{
		driver.findElement(searchfor).sendKeys("shorts");
		driver.findElement(By.id("searchSubmit")).click();
	}
	public void clickBrand()
	{
		driver.findElement(clickBrand).click();
	}
	public void choseBrand()
	{
		List<WebElement> options = driver.findElements(choseBrand);
		Random rand = new Random();
		int list= rand.nextInt(options.size());
		options.get(list).click();
	}
	public void pickitem()
	{
		try {
		List<WebElement> results = driver.findElements(pickitem);
		Random rand = new Random();
		int list= rand.nextInt(results.size());
		results.get(list).click();
		}
		catch(Exception e) {
			
			List<WebElement> results = driver.findElements(pickitem);
			Random rand = new Random();
			int list= rand.nextInt(results.size());
			results.get(list).click();
		}
	}
	public void SelectSize()
	{
		try
		{
			driver.findElement(SelectSize).click();
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//a[@class='view-more-sizes-link']")).click();
			Actions action = new Actions(driver);
			action.click(driver.findElement(SelectSize)).perform();
			//driver.findElement(SelectSize).click();
		}
	}
	public void AddtoList()
	{
		driver.findElement(AddtoList).click();
	}
}
