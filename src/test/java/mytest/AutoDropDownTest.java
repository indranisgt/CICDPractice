package mytest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class AutoDropDownTest extends base {

	@BeforeTest
	public void initBrowser() throws IOException {
		chooseBrowser();
		driver.get(prop.getProperty("url2"));

	}

	@Test
	public void auto() {
		driver.findElement(By.cssSelector(".inputs.ui-autocomplete-input")).sendKeys("ind");
		driver.findElement(By.cssSelector(".inputs.ui-autocomplete-input")).sendKeys(Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String text = "return document.getElementById(\"autocomplete\").value;";
		System.out.println(js.executeScript(text));
		// String script = "return document.getElementById(\"fromPlaceName\").value;";
		driver.findElement(By.id("name")).sendKeys("indrani");
		driver.findElement(By.id("alertbtn")).click();
		driver.switchTo().alert().accept();
	}

	@AfterTest
	public void close() {
		closeBrowser();

	}
}
