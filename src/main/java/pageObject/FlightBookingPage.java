package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightBookingPage {

	public WebDriver driver;

	public FlightBookingPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	By origin = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	By org_city = By.xpath("//a[@value='BLR']");
	By destination = By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='CCU']");
	By depart_date = By.cssSelector(".ui-state-default.ui-state-highlight");
	By return_date = By.cssSelector("input[id='ctl00_mainContent_view_date2']");

	public WebElement origin() {
		return driver.findElement(origin);
	}

	public WebElement org_city() {
		return driver.findElement(org_city);
	}

	public WebElement dest() {
		return driver.findElement(destination);
	}

	public WebElement depart_date() {
		return driver.findElement(depart_date);
	}

	public WebElement return_date() {
		return driver.findElement(return_date);
	}

}
