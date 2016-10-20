package Yatratable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

 public class table{
	@Test
	public void Yatra() throws InterruptedException
	{
	WebDriver driver = new FirefoxDriver(); //creating object for firefox
	driver.manage().window().maximize();  //command to maximize the window
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.yatra.com/");
	//mouseover
	WebElement menu = driver.findElement(By.xpath("//li[@class='moreNav list-dropdown js_yt_header_top']"));
	Actions actions = new Actions(driver);
	actions.moveToElement(menu).build().perform();
	//click on Flight
	driver.findElement(By.xpath("//a[@class='simple-tab eventTrackable' and @title='Flights']")).click();
	//click on one way
	driver.findElement(By.xpath("//a[@class='type-active']/i[@class='sprite-booking-engine ico-be-radio hide']")).isSelected();
	
	if(driver.findElement(By.xpath("//a[@class='type-active']/i[@class='sprite-booking-engine ico-be-radio hide']")).isSelected()==false);
	{
		driver.findElement(By.xpath("//a[@class='type-active']/i[@class='sprite-booking-engine ico-be-radio hide']")).click();
	}
	
	//sendkeys
	driver.findElement(By.xpath("//input[@id='BE_flight_origin_city']")).sendKeys("Delhi");
	driver.findElement(By.xpath("//input[@id='BE_flight_arrival_city']")).sendKeys("Colombo");
	//click on calendar
	driver.findElement(By.xpath("//input[@id='BE_flight_depart_date']")).click();
	//click on month
	driver.findElement(By.xpath("//a[@href='#PegasusCal-0-month-1-2017']")).click();
	//click on date
	driver.findElement(By.xpath("//td[@id='td_2017_1_20']/a/span[contains(text(),'10,210')]")).click();
    //click on search
	driver.findElement(By.xpath("//input[@id='BE_flight_flsearch_btn']")).click();
	
	List<WebElement> l1 = driver.findElements(By.xpath("//div[@class='full mt20 mb10 pr new-theme sort-nav']/ul"));
	System.out.println("No of count"+l1.size());
	Thread.sleep(5000);
    driver.close();
	}
 }
 