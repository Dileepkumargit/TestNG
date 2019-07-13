import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {
	WebDriver driver;
	
	Checkbox(WebDriver driver)
	{
	   this.driver = driver;	
	}
	
	
	public List<String> getBrands() 
	 {
		 List<WebElement> Brands = driver.findElements(By.xpath(".//h4[(text()=\"Brands\")]/following-sibling::ul[1]//span"));
	     return Brands.stream().map(a -> a.getText()).distinct().collect(Collectors.toList());
	 }
	 public  void SelectBrand(String object)
	 {
		 driver.findElement(By.xpath(".//h4[(text()=\"Brands\")]/following-sibling::ul[1]//span[(text()=\""+ object+"\")]")).click();
	 }

}
