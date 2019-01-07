package lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class multibrowsers {

	static WebDriver driver;
	@Test
	@Parameters("browser")
	public void launchmultibrowsers(String browserName) {
		
		if(browserName.equalsIgnoreCase("firefox")) {
			
			//System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Browsers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			}
		else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Browsers\\chromedriver.exe");
			driver = new ChromeDriver();
					
		}
		else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Browsers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}
		
				driver.manage().window().maximize();
				try {
					Thread.sleep(3000l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.get("http://www.google.com");
				System.out.println(driver.getTitle());
				//driver.quit();
		
	}
	
	
	
}
