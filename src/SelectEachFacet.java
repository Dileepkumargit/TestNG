import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectEachFacet {
    private static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chrormeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("shirts");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Men facet= new Men(driver);
		List<String> Mens = facet.getMens();
    	System.out.println(Mens.toString());
    	String facetitem = Mens.get(new Random().ints(0,Mens.size()-1).findFirst().getAsInt());
    	System.out.println(facetitem);
    	facet.SelectMen(facetitem);
		
	}//.//h4[(text()=\"Men\")]/following-sibling::ul[1]//span

}
