package IrctcAssert;
import java.util.List;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Irctcassert{
	WebDriver driver=null;
    @Parameters({"browser","browser1"})
    @Test
    public void setup(String browser, String browser1) throws Exception
    {
    	if(browser.equals("FireFox"))
    	{
    		 driver = new FirefoxDriver();
    		 irctc2();
//    		 if(browser1.equals("chrome"))
//    	    	{
//    	    		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
//    	      		driver = new ChromeDriver();
//    	      		irctc2();
//    	    	}
    	}
//    	if(browser1.equals("FireFox"))
//    	{
//    		 driver = new FirefoxDriver();
//    		 irctc2();
//    	}
    	if(browser1.equals("chrome"))
    	{
    		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
      		driver = new ChromeDriver();
      		irctc2();
    	}
    	
    }
	
	public void irctc2() throws InterruptedException, IOException
	{
//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
//	WebDriver driver = new ChromeDriver(); //creating object for firefox
//	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();  //command to maximize the window
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	//click on flight
	driver.findElement(By.xpath("//*[@id='bluemenu']/ul/li[5]/a")).click();
	//open a new window
	String pw = driver.getWindowHandle();
	Set<String> allwin = driver.getWindowHandles();
	for(String s : allwin)
	{
		if(s.equals(pw)==false)
		{
		driver.switchTo().window(s);
		
		break;
		}
		
	}
	// Using assert for checking "air" in flight URL
	String s = driver.getCurrentUrl();
	Assert.assertTrue(s.contains("air"));
	//Using assert for checking one way 
	Assert.assertTrue(driver.findElement(By.xpath("//input[@name='tripType' and @value='One way']")).isSelected());
	//Using assert for checking Round trip
	Assert.assertFalse(driver.findElement(By.xpath("//div[@class='roundtripradio']/input[@name='tripType']")).isSelected());
	
	
	// Enter starting point
	driver.findElement(By.xpath("//input[@id='origin']")).sendKeys("Delhi");
	driver.findElement(By.xpath("//a[contains(text(),'Delhi (New Delhi),DEL')]")).click();
	// Enter destination point
	driver.findElement(By.xpath("//input[@id='destination']")).sendKeys("goa");
	driver.findElement(By.xpath("//a[contains(text(),'Goa,GOI')]")).click();
	//click on depart
	driver.findElement(By.xpath("//input[@id='departDate']/following-sibling::img")).click();
	//click on date
	driver.findElement(By.xpath("//a[contains(text(),'20')]")).click();
	//click on adult 
	driver.findElement(By.xpath("//select[@id='noOfAdult']/option[@value='2']")).click();
	//click on child
	driver.findElement(By.xpath("//select[@id='noOfChild']/option[@value='1']")).click();
	//click on search
	driver.findElement(By.xpath("//div[@onclick='submitSearch();']")).click();
	// calculating total no of flight
	List<WebElement> alllist = driver.findElements(By.xpath("//div[@class='onewayflightinfo']"));
	Assert.assertTrue(alllist.size()>0 && alllist.size()<100);
	System.out.println("Number of count "+alllist.size());
	
	Thread.sleep(5000);
	driver.close();
	
	
	}	
}