package MavenJenkins;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BusinessChoiceChromeTest11to20 {
  
	static WebDriver driver;
	@Test(dataProvider= "URLsfromCorps") 
			
  public void f(String url) {
	  
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Browsers\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Hi, how are you today?"+ " This is the test for "+ url);
		//Lunch the URL
		String url1 = "https://www" + url;
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(url1);
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Sign in with the member details
		driver.findElement(By.xpath("//div[contains(@class,'m-bottom-15 emailPCR')]/input")).sendKeys("129924419");
		driver.findElement(By.xpath("//div[contains(@class,'m-bottom-15 pinPCR')]/input")).sendKeys("se ");
		driver.findElement(By.xpath("//button[@id='tpiSubmitButton']")).click();
		//Navigates to the Corporate page
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//div[@class='ResModule section']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(By.xpath("//input[@id='destination']")).click();
		//Randomize the value in the destination field
		List<String> givenList = Arrays.asList("Miami, Florida, USA", "Denver, Colorado, United States", "Austin, Texas, United States", "Kansas City, Kansas, United States","Camden, Arkansas, United States" );
		Random rand = new Random();
	    String randomElement = givenList.get(rand.nextInt(givenList.size()));
		driver.findElement(By.xpath("//input[@id='destination']")).sendKeys(randomElement);
		driver.findElement(By.xpath("//div[@class='checkin']//span[@title='Select to open calendar.'][contains(text(),'Select to open calendar.')]")).click();
		System.out.println("Yay! We are going to " + randomElement);
		try {
			Thread.sleep(3000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='checkInDate']")).sendKeys("Jan-27-2019");
		driver.findElement(By.xpath("//input[@id='checkOutDate']")).sendKeys("Jan-30-2019");
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
			Thread.sleep(6000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Click on the first hotel which has "Select Hotel" available 
		WebElement ElementSelect = driver.findElement(By.xpath("(//div[contains(text(),'SELECT HOTEL')])[1]"));
		//js.executeScript("arguments[0].scrollIntoView();", ElementSelect);
		ElementSelect.click();
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
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Select the Room Type
		WebElement Element3 = driver.findElement(By.xpath("(//div[@class='roomColumnContainer']//aside//span[contains(.,'SELECT ROOM')])[1]"));
		js.executeScript("arguments[0].scrollIntoView();", Element3);
		Element3.click();
		try {
			Thread.sleep(4000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Select the Corporate Rate
		try {
			driver.findElement(By.xpath("(//div[contains(text(),'Select Rate')])[2]")).click();
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
		WebElement Element5 = driver.findElement(By.xpath("//div[contains(text(),'Select Rate')]"));
		js.executeScript("arguments[0].scrollIntoView();", Element5);
		Element5.click();
		}
		
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Enter Guest Information
		
	    //Scroll down to Payment Card Type field
	    WebElement Element4 = driver.findElement(By.xpath("//div[@class='col-xs-12']//div[@class='row']/div[3]/div"));
	 	js.executeScript("arguments[0].scrollIntoView();",Element4);
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
	 	System.out.println("This is the reservation number " +ConfNumval+ " for the url "+url);
	 	driver.quit();
	
	  
  }
	@AfterMethod
	public void screenShot(ITestResult result) {
		
		if(ITestResult.FAILURE==result.getStatus()){
		
			try{
				
				 // To create reference of TakesScreenshot
				 TakesScreenshot screenshot=(TakesScreenshot)driver;
				 // Call method to capture screenshot
				 File source=screenshot.getScreenshotAs(OutputType.FILE);
				 // Copy files to specific location 
				 // result.getName() will return name of test case so that screenshot name will be same as test case name
				 FileHandler.copy(source, new File("./ScreenShots/"+result.getName()+"chrome"+ ".png"));
				 System.out.println("Successfully captured a screenshot");
				 }catch (Exception e){
				 System.out.println("Exception while taking screenshot "+e.getMessage());
				
				 } 
		}
	}
	@DataProvider(name="URLsfromCorps")
	public Object[] passData() {
	
	Object[] data = new Object[10];
	
	/*String bchome = ".ihg.com/hotels/us/en/global/bc/home";
	String threem = ".ihg.com/hotels/us/en/global/bc/3m?corporateNumber=101672";
	String att = ".ihg.com/hotels/us/en/global/bc/att?corporateNumber=150711";
	String air = ".ihg.com/hotels/us/en/global/bc/air_products?corporateNumber=106861";
	String amex = ".ihg.com/hotels/us/en/global/bc/amex?corporateNumber=100194131";
	String bakerhughes  = ".ihg.com/hotels/us/en/global/bc/bakerhughes?corporateNumber=100862713";
	String barcklays = ".ihg.com/hotels/us/en/global/bc/barclays?corporateNumber=954414832";
	String brinker =".ihg.com/hotels/us/en/global/bc/brinker?corporateNumber=100862233";
	String collective = ".ihg.com/hotels/us/en/global/bc/collective?corporateNumber=100189116";
	String comair= ".ihg.com/hotels/us/en/global/bc/comair?corporateNumber=100861831";
	*/
	String conway = ".ihg.com/hotels/us/en/global/bc/conway?corporateNumber=100224634";
	String cypress = ".ihg.com/hotels/us/en/global/bc/cyprexx?corporateNumber=100273209";
	String delphi = ".ihg.com/hotels/us/en/global/bc/delphi?corporateNumber=100185640";
	String dresser = ".ihg.com/hotels/us/en/global/bc/dresser?corporateNumber=127256";
	String eds =".ihg.com/hotels/us/en/global/bc/eds?corporateNumber=136905";
	String ericssongold = ".ihg.com/hotels/us/en/global/bc/ericsson_gold?corporateNumber=954299722";
	String ericssonab = ".ihg.com/hotels/us/en/global/bc/ericsson_ab?corporateNumber=954600727";
	String ericsson = ".ihg.com/hotels/us/en/global/bc/ericsson?corporateNumber=954299722";
	String faa = ".ihg.com/hotels/us/en/global/bc/faa?corporateNumber=100185863";
	String fedex = ".ihg.com/hotels/us/en/global/bc/fedex?corporateNumber=109207";
	/*String gecapital = ".ihg.com/hotels/us/en/global/bc/ge_capital?corporateNumber=249807";
	String gemedical = ".ihg.com/hotels/us/en/global/bc/ge_medical?corporateNumber=100186692";
	String ge = ".ihg.com/hotels/us/en/global/bc/ge?corporateNumber=102806";
	String honda = ".ihg.com/hotels/us/en/global/bc/honda?corporateNumber=100371240";
	String iandc = ".ihg.com/hotels/us/en/global/bc/i_and_c?corporateNumber=100253358";
	String ihgcorp = ".ihg.com/hotels/us/en/global/bc/ihg_corp?corporateNumber=404604";
	String ihg = ".ihg.com/hotels/us/en/global/bc/ihg?corporateNumber=954408789";
	String johnson = ".ihg.com/hotels/us/en/global/bc/johnson?corporateNumber=589446";
	String joymining = ".ihg.com/hotels/us/en/global/bc/joy_mining?corporateNumber=100185142";
	String kroger = ".ihg.com/hotels/us/en/global/bc/kroger?corporateNumber=117935";
	String lee = ".ihg.com/hotels/us/en/global/bc/lee?corporateNumber=100245072";
	String lucent = ".ihg.com/hotels/us/en/global/bc/lucent?corporateNumber=100859221";
	String navistar = ".ihg.com/hotels/us/en/global/bc/navistar?corporateNumber=142867";
	String nextera = ".ihg.com/hotels/us/en/global/bc/nextera?corporateNumber=112976";
	String nishaa= ".ihg.com/hotels/us/en/global/bc/nissha?corporateNumber=100277765";
	String nortel = ".ihg.com/hotels/us/en/global/bc/nortel?corporateNumber=323098";
	String omnicell = ".ihg.com/hotels/us/en/global/bc/omnicell?corporateNumber=100193399";
	String pall = ".ihg.com/hotels/us/en/global/bc/pall?corporateNumber=852155";
	String payless = ".ihg.com/hotels/us/en/global/bc/payless?corporateNumber=100189116";
	String planb = ".ihg.com/hotels/us/en/global/bc/planb?corporateNumber=100285058"; 
	String ricoh = ".ihg.com/hotels/us/en/global/bc/ricoh?corporateNumber=100197075";
	String scjohnson = ".ihg.com/hotels/us/en/global/bc/sc_johnson?corporateNumber=100214750";
	String timHortons = ".ihg.com/hotels/us/en/global/bc/tim_hortons?corporateNumber=100200163";
	String veolia = ".ihg.com/hotels/us/en/global/bc/veolia?corporateNumber=100183846";
	String wasteMgt = ".ihg.com/hotels/us/en/global/bc/waste_mgt?corporateNumber=123137";
	String zenon = ".ihg.com/hotels/us/en/global/bc/zenon?corporateNumber=900000935";
	*/
	/*data[0]=bchome;
	data[1]= threem ;
	data[2]= att;
	data[3]= air;
	data[4]= amex;
	data[5] = bakerhughes;
	data[6] = barcklays;
	data[7]= brinker;
	data[8]= collective;
	data[9]= comair;*/
	data[0]= conway;
	data[1]= cypress;
	data[2]= delphi;
	data[3]= dresser;
	data[4]= eds;
	data[5]= ericssongold;
	data[6]= ericssonab;
	data[7]= ericsson;
	data[8]= faa;
	data[9]= fedex;
	/*data[20]= gecapital;
	data[21]= gemedical;
	data[22]= ge;
	data[23]= honda;
	data[24]= iandc;
	data[25]= ihgcorp;
	data[26]= ihg;
	data[27]= johnson;
	data[28]= joymining;
	data[29]= kroger;
	data[30]= lee;
	data[31]= lucent;
	data[32]= navistar;
	data[33]= nextera;
	data[34]= nishaa;
	data[35]= nortel;
	data[36]= omnicell;
	data[37]= pall;
	data[38]= payless;
	data[39]= planb;
	data[40]= ricoh;
	data[41]= scjohnson;
	data[42]= timHortons;
	data[43]= veolia;
	data[44]=wasteMgt;
	data[45]= zenon;
	*/
	
	return data;
		}
	
}

