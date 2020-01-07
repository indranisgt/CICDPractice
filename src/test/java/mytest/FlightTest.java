package mytest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.FlightBookingPage;
import resources.base;

public class FlightTest extends base{
	
	@BeforeTest
	public void initBrowser() throws IOException {
		chooseBrowser();
		driver.get(prop.getProperty("url"));
		driver.findElement(By.cssSelector("a[href='https://rahulshettyacademy.com/dropdownsPractise/']")).click();
		Set<String> s= driver.getWindowHandles();
		Iterator<String> it = s.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);

	}
	
	@Test
	public void flightBooking() throws InterruptedException {
		FlightBookingPage fp = new FlightBookingPage(driver);
		fp.origin().click();
		fp.org_city().click();
		fp.dest().click();
		fp.depart_date().click();
	/*	for(int i=0; i<driver.findElements(By.cssSelector("input[type='radio']")).size();i++) {
		String text= 	driver.findElements(By.cssSelector("input[type='radio']")).get(i).getAttribute("value");
		if(text.equalsIgnoreCase("RoundTrip")) {
			driver.findElements(By.cssSelector("input[type='radio']")).get(i).click();
		}
	
		}*/
		
		driver.findElement(By.id("divpaxinfo")).click();
		driver.findElement(By.id("hrefIncAdt")).click();
		driver.findElement(By.id("btnclosepaxoption")).click();
		Select s = new Select(driver.findElement(By.id(("ctl00_mainContent_DropDownListCurrency"))));
		s.selectByValue("USD");
		
		for (int i=0; i<driver.findElements(By.xpath("//input[@type='checkbox']")).size(); i++) {
		String text=	driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).getAttribute("name");
		System.out.println(text);
		if (text.contains("Ind")) {
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElements(By.xpath("//input[@type='checkbox']")).get(i)).build().perform();
			driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).click();
		}
		}
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		/*if(fp.return_date().getAttribute("style").contains("1")) {
			System.out.println(fp.return_date().isEnabled());
		}
			
		fp.return_date().click();*/
		
	/*	while(!driver.findElement(By.cssSelector(".ui-datepicker-title")).getText().contains("May")) {
			driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
		}
		
	}*/
		
	}
	
@AfterTest
	public void close() {
		closeBrowser();
		
	}


}