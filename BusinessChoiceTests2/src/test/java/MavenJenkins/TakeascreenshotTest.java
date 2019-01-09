package MavenJenkins;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

@Test
public class TakeascreenshotTest {
	static WebDriver driver;
	public static void takescreenshot() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Browsers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@title='Search']")).click();
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("How are you today");
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source, new File("./ScreenShots/poc.png"));
		System.out.println("screenshots taken");
		
		
		
		
		
		
	}

}
