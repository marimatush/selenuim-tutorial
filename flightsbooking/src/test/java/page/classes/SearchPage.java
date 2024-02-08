package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	public static WebElement element = null;
	
	public static WebElement destinationBtn(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@data-stid='destination_form_field-menu-trigger']"));
		return element;
	}
	
	public static WebElement destinationInput(WebDriver driver) {
		WebElement destBtn = destinationBtn(driver);
		destBtn.click();
		element = driver.findElement(By.xpath("//input[@data-stid='destination_form_field-menu-input']"));
		return element;
	}
	
	public static WebElement searchBtn(WebDriver driver) {
		element = driver.findElement(By.id("search_button"));
		return element;
	}
	
	public static void clickSearchButton(WebDriver driver) {
		element = searchBtn(driver);
		element.click();
	}
	
	public static void navigateToFlightsTab(WebDriver driver) {
		driver.findElement(By.id("header-history")).click();
		element = driver.findElement(By.id("tab-flight-tab"));
		element.click();
	}
}
