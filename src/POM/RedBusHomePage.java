package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RedBusHomePage {
	
	WebDriver driver;
	
	By from  = By.id("src");
	By fromA = By.xpath("//li[text()='"+"Bangalore (All Locations)"+"']");
	By to    = By.id("dest");
	By toA   = By.xpath("//li[text()='"+"Hyderabad (All Locations)"+"']");
	By date  = By.id("rb-calendar_onward_cal");
	By Month = By.xpath("//div[@id='rb-calendar_onward_cal']//td[@class='monthTitle']");
    By click3 = By.id("search_btn");
    
    public RedBusHomePage(WebDriver driver)
    {
    	this.driver =driver;
    }
	public void from() {
		driver.findElement(from).sendKeys("Bangalore");
		
	}
	public void fromA() {
		driver.findElement(fromA).click();
		
	}
	public void to() {
		driver.findElement(to).sendKeys("Hyderabad");
		
	}
	public void toA() {
		driver.findElement(toA).click();
		
	}
	public void date() {
		driver.findElement(date).click();
		
	}
	public void Month() {
		while(!driver.findElement(Month).getText().equals("May 2019"))
		driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//td[@class='next']/button")).click();
		driver.findElements(click3).stream().filter(a->a.getText().equals("25")).findFirst().get().click();

	}
	

	public void click3() {
		driver.findElement(click3).click();
	}
	
	    
}
