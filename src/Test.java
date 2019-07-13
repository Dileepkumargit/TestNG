import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Test {
	public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		System.out.println("start");
		for(int i = 0;i<5;i++)
		{
			if(i>=2) {
				@SuppressWarnings("null")
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				driver.getPageSource();
				// Code to copy the screenshot in the desired location
				FileUtils.copyFile(scrFile, new File("C:\\CaptureScreenshot\\google.jpg"));
				}
			
			System.out.println("print 0");						
		}

}
}

