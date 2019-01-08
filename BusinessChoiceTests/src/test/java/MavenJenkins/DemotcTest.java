package MavenJenkins;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DemotcTest {

	static WebDriver driver;
	@Test
	public void testHello() {
	System.out.println("Hello");
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Browsers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://www.google.com");
	Assert.assertTrue(driver.getTitle().contains("Google"));
	}
}
