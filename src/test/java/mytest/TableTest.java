package mytest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.base;

public class TableTest extends base {
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initbrowser1() throws IOException {
		
		chooseBrowser();
		driver.get(prop.getProperty("url"));
		log.info("launched");
	}

	
	@Test
	public void tabledata() throws InterruptedException {
		LandingPage lp = new LandingPage(driver);
		lp.top_deal().click();
		Set<String> s= driver.getWindowHandles();
		Iterator<String> it=s.iterator();
		String parent= it.next();
		String child = it.next();
		driver.switchTo().window(child);
		int count = driver.findElements(By.cssSelector("tr td:nth-child(2)")).size();
		System.out.println(count);
		ArrayList<String> original = new ArrayList<String>();
		ArrayList<String> copy = new ArrayList<String>();
		for(int i=0; i<count; i++){
		String items= 	driver.findElements(By.cssSelector("tr td:nth-child(2)")).get(i).getText();
		original.add(items);
		}
		for(int i=0; i<original.size(); i++) {
			copy.add(original.get(i));
		}
		Collections.sort(copy);
		for(int i=0; i<copy.size(); i++) {
		log.info(copy.get(i));
		}
	/*	int count_price = driver.findElements(By.cssSelector("tr td:nth-child(3)")).size();
		System.out.println(count_price);
		ArrayList<String> original_price = new ArrayList<String>();
		ArrayList<String> copy_price = new ArrayList<String>();
		for(int i=0; i<count_price; i++){
		String items_price= 	driver.findElements(By.cssSelector("tr td:nth-child(3)")).get(i).getText();
		original_price.add(items_price);
		}
		for(int i=0; i<original_price.size(); i++) {
			copy_price.add(original_price.get(i));
		
		}
		
	Arrays.sort(copy_price.toArray());
		for(int i=0; i<copy_price.size(); i++) {
		System.out.println(copy_price.get(i));	
		}*/
	}
	
	@AfterTest
	public void close() {
		closeBrowser();
		log.info("stopped");
	}
}
