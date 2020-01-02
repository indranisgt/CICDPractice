package mytest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.base;

public class CartTest extends base{

	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initbrowser() throws IOException {
		
		chooseBrowser();
		driver.get(prop.getProperty("url"));
		log.info("launched");
	}
	
	@Test
	public void addItem() {
		//ArrayList<String> a = new ArrayList<String>();
		LandingPage lp = new LandingPage(driver);
		int j=0;
		String[] items= {"Cucumber", "Brinjal", "Tomato"};
		List<WebElement> list = driver.findElements(By.cssSelector("h4[class='product-name']"));
		//int count = driver.findElements(By.cssSelector("h4[class='product-name']")).size();
		
		for(int i=0; i<list.size(); i++) {
			String[] itemname= list.get(i).getText().split("-");
			String formattedname= itemname[0].trim();
		List itemslist=	Arrays.asList(items);
			if(itemslist.contains(formattedname)) {
				j++;
				lp.getbutton().get(i).click();
				log.info("clicked");
				
				if(j==items.length) {
					break;
				}
			}
		}
		
	}
	
	
	@AfterTest
	public void close() {
		closeBrowser();
		log.info("stopped");
	}

}
