import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dileep {
	
	static String Brand;
	static WebDriver driver;	
	public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver", "E:\\chrormeDriver\\chromedriver.exe");
 	     driver = new ChromeDriver();
 	     driver.get("https://www.amazon.in");
 	     //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 	     driver.findElement(By.id("twotabsearchtextbox")).sendKeys("shirts");
 	     driver.findElement(By.xpath("//input[@type='submit']")).click();
 	     Checkbox facet = new Checkbox(driver);
 	     List<String> allBrands = facet.getBrands();
 	     System.out.println(allBrands.toString());
 	     int index = new Random().nextInt(allBrands.size()-1);
 	     //Brand = allBrands.get(index);
 	     facet.SelectBrand(allBrands.get(index));
 	     System.out.println(allBrands);
 	   
 	    
	}
	

}
