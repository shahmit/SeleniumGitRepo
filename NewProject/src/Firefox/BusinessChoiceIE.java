package Firefox;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BusinessChoiceIE {
  
	static WebDriver driver;
	@Test(dataProvider= "URLsfromCorps")
  public void f(String url) {
	  
		System.setProperty("webdriver.edge.driver", "C:\\Program Files\\Browsers\\MicrosoftWebDriver.exe");
		WebDriver driver =new EdgeDriver();
		driver.manage().window().maximize();
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//Lunch the URL
		String url1 = "https://staging.www" + url;
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().deleteAllCookies();
		driver.get(url1);
		driver.manage().window().maximize();
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Sign in with the member details
		WebElement loginelement = driver.findElement(By.xpath("//div[contains(@class,'m-bottom-15 emailPCR')]/input"));
		if (loginelement.isDisplayed()) {
		driver.findElement(By.xpath("//div[contains(@class,'m-bottom-15 emailPCR')]/input")).sendKeys("176380600");
		driver.findElement(By.xpath("//div[contains(@class,'m-bottom-15 pinPCR')]/input")).sendKeys("7890");
		driver.findElement(By.xpath("//button[@id='tpiSubmitButton']")).click();
		}
		
		//Navigates to the Corporate page
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//label[@for='destination']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys("Las Vegas, NV, USA");
		driver.findElement(By.xpath("//div[@class='checkin']//span[@title='Select to open calendar.'][contains(text(),'Select to open calendar.')]")).click();
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='checkInDate']")).sendKeys("Jan-26-2019");
		driver.findElement(By.xpath("//input[@id='checkOutDate']")).sendKeys("Jan-29-2019");
		driver.findElement(By.xpath("//label[@for='ratePreference']")).click();
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='lessSearchSubmit']")).click();
		//Select the available Hotel
		try {
			Thread.sleep(4000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Click on the first hotel which has "Select Hotel" available 
		driver.findElement(By.xpath("(//div[contains(text(),'SELECT HOTEL')])[1]")).click();
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Skip the step if 'Select the type of room..' pop up appears
		try {
			driver.findElement(By.xpath("//div[@class='hSixteen skipStepText ng-binding ng-scope']")).isDisplayed();
			driver.findElement(By.xpath("//div[@class='hSixteen skipStepText ng-binding ng-scope']")).click();
			System.out.println("Clicked Skip Step");
			}
		catch (org.openqa.selenium.NoSuchElementException e){
			System.out.println("Didnt find the Skip step");
			
		}
		//Select the Room Type
		driver.findElement(By.xpath("//div[@class='tab-pane ng-scope active']//div[@class='roomContainer first']//span[@class='ng-binding'][contains(text(),'SELECT ROOM')]")).click();
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Select the Corporate Rate
		driver.findElement(By.xpath("(//div[contains(text(),'Select Rate')])[2]")).click();
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Enter Guest Information
		
	    //Scroll down to Payment Card Type field
	    WebElement Element3 = driver.findElement(By.xpath("//div[@class='col-xs-12']//div[@class='row']/div[3]/div"));
	 	js.executeScript("arguments[0].scrollIntoView();",Element3);
	 	 //identify Payment Type Method
	    WebElement paymentmethod = driver.findElement(By.xpath("//button[@id='paymentCard']"));
	    paymentmethod.click();
	    driver.findElement(By.xpath("//li[contains(text(),'VISA')]")).click();
	 	//Identify Card Number
	    driver.findElement(By.xpath("//input[@id='cardNumber']")).sendKeys("4111111111111111");
	    //Expiration Date
	    //indentify the field
	    driver.findElement(By.xpath("//div[@class='btn-group paymentInfoSelect select expDateField']"));
	    //identify the list
	    List <WebElement> dd_expirationdate = driver.findElements(By.xpath("//select[@id='cardExpirationMonth']/option"));
	    //iterate the values in the Expiration date dd
	    for (int i=0; i<dd_expirationdate.size(); i++) {
	    	WebElement valueexpirationdate = dd_expirationdate.get(i);
	    	String innerhtml=valueexpirationdate.getAttribute("innerHTML");
	    	System.out.println("values from Expiration date dropdown are..."+innerhtml);
	    	if(innerhtml.contentEquals("04 (April)")) {
	    		System.out.println("Found a match! Trying to click!");
	     		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    		valueexpirationdate.click();
	    		break;
	    }
	    }
	    //Expiration Year
	    //identify the field
	    driver.findElement(By.xpath("//select[@id='cardExpirationYear']"));
	    //Iterate the list
	    List<WebElement> dd_expirationyear = driver.findElements(By.xpath("//select[@id='cardExpirationYear']/option"));
	    for (int i=0; i<dd_expirationyear.size(); i++) {
	    WebElement valueddexpirationyear = dd_expirationyear.get(i);
	    String innerhtml=valueddexpirationyear.getAttribute("innerHTML");
	    System.out.println("values from Expiration Year dropdown are..."+innerhtml);
	    if(innerhtml.contentEquals("2022")) {
	    	System.out.println("Found a match! Trying to click!");
	 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 		valueddexpirationyear.click();
	 		break;
	    	
	    }
	    
	    }
	    WebElement tandc = driver.findElement(By.xpath("//div[@class='terms-conditions-heading hEight ng-binding']"));
	 	js.executeScript("arguments[0].scrollIntoView();",tandc);
	 	driver.findElement(By.xpath(" //label[@for='terms']//span[@class='checkBox fa-stack fa-lg themeFill']")).click();
	 	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 	driver.findElement(By.xpath("//span[contains(text(),'BOOK RESERVATION')]")).click();
	 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	WebElement ConfNum = driver.findElement(By.xpath("(//p[1]/span[1])[2]"));
	 	String ConfNumval= ConfNum.getText();
	 	System.out.println("This is the reservation number " +ConfNumval);
	 	driver.quit();
	
	  
  }
	@DataProvider(name="URLsfromCorps")
	public Object[] passData() {
	
	Object[] data = new Object[3];
		
	data[0]=".ihg.com/hotels/us/en/global/bc/home";
	data[1]=".ihg.com/hotels/us/en/global/bc/3m?corporateNumber=101672";
	data[2]=".ihg.com/hotels/us/en/global/bc/att?corporateNumber=150711";
		return data;
		}
	
}

