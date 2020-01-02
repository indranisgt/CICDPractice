package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		//super();
		this.driver = driver;
	}
	
	
	By button = By.xpath("//div[@class='product-action']/button");
	
	public List<WebElement> getbutton() {
		return driver.findElements(button);
	}
	
}
