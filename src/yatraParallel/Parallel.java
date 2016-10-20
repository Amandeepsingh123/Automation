package yatraParallel;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

 public class Parallel{
	//WebDriver driver=null;
	@Test
	public void YatraP() throws InterruptedException, IOException
	{
	WebDriver driver = new FirefoxDriver(); //creating object for firefox
//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
//	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();  //command to maximize the window
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.yatra.com/");
	WebElement menu = driver.findElement(By.xpath("//li[@id='userSignInStrip']"));
	//class to perform drop down
	Actions actions= new Actions(driver);
    actions.moveToElement(menu).perform();
    driver.findElement(By.linkText("My Bookings")).click();
    Thread.sleep(5000);
    driver.close();
	}
	
	@Test
	public void YatraPa() throws InterruptedException, IOException
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
  	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();  //command to maximize the window
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.yatra.com/");
	WebElement menu = driver.findElement(By.xpath("//li[@id='userSignInStrip']"));
	//class to perform drop down
	Actions actions= new Actions(driver);
    actions.moveToElement(menu).perform();
    driver.findElement(By.linkText("My Bookings")).click();
    Thread.sleep(5000);
    driver.close();
	}
 }