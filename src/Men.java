import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Men {
	WebDriver driver;

	 Men(WebDriver driver)
	 {
		 this.driver = driver;
	 }
	
	 public List<String> getMens() 
	 {
		 List<WebElement> Mens = driver.findElements(By.xpath(".//h4[(text()=\"Men\")]/following-sibling::ul[1]//span"));
	     return Mens.stream().map(a -> a.getText()).distinct().collect(Collectors.toList());
	 }
	 public  void SelectMen(String object)
	 {
		 driver.findElement(By.xpath(".//h4[(text()=\"Men\")]/following-sibling::ul[1]//span[(text()=\""+ object+"\")]")).click();

	}	

}
