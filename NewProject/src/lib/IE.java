package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class IE {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Browsers\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
	}

}
