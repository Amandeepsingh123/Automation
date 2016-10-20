// Example for radio and date 
package Make2;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class makemytrip
{
	@Test
	public void Make2() throws InterruptedException
	{
    WebDriver driver = new FirefoxDriver(); //creating object for firefox
	driver.manage().window().maximize();  //command to maximize the window
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com/");
	//click on drop down
	driver.findElement(By.xpath("//span[@class='arrow_downall']")).click();
	//click on intenational flights
	driver.findElement(By.xpath("//span[contains(text(),'International Flights')]")).click();
	//opening new window
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
	System.out.println("Current url"+driver.getCurrentUrl());
	//click on radio button
//	driver.findElement(By.xpath("//a[@id='one_way_button1']/span[@class='radio_state']")).isSelected();
//	if(	driver.findElement(By.xpath("//a[@id='one_way_button1']/span[@class='radio_state']")).isSelected() == false)
//	{
//		driver.findElement(By.xpath("//a[@id='one_way_button1']/span[@class='radio_state']")).click();
//	}
	//Sending  Delhi to text field
	WebElement a1 = driver.findElement(By.xpath("//input[@id='from_typeahead1']"));
	a1.sendKeys("Delhi");
	//sending Mumbai to text field
	WebElement a2 = driver.findElement(By.xpath("//input[@id='to_typeahead1']"));
	a2.sendKeys("Mumbai");
//	List<WebElement> l1 = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']"));
//	System.out.println(l1.size());
//	int count = l1.size();
//	for(int i=0;i<count;i++)
//	{
//		
//		String date = l1.get(i).getText();
//		
//		if(date.equalsIgnoreCase("12"))
//		{
//			l1.get(i).click();
//			break;
//		}
//		
//	}
	//click on calender
	driver.findElement(By.xpath("//a[@id='start_date_sec']/span[@class='glyphicon glyphicon-calendar flL']")).click();
	//click on arrow
	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	//click on 20
	driver.findElement(By.xpath("//a[contains(text(),'12')]")).click();
	//click on destination calender
	driver.findElement(By.xpath("//a[@id='return_date_sec']/span[@class='glyphicon glyphicon-calendar flL']")).click();
	//click on date
	driver.findElement(By.xpath("//td[@class=' ui-datepicker-week-end ']/a[contains(text(),'19')]")).click();
	//click on search
	driver.findElement(By.xpath("//a[@id='flights_submit']")).click();	
	
	Thread.sleep(5000);
	
	driver.close();
	}
}
