package basicweb;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {
	private WebDriver driver;
	
	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(String locator, String type) {
		type = type.toLowerCase();
		WebElement element;
		if (type.equals("id")) {
			element = this.driver.findElement(By.id(locator));
		} else if (type.equals("xpath")) {
			element = this.driver.findElement(By.xpath(locator));			
		} else if (type.equals("name")) {
			element = this.driver.findElement(By.name(locator));			
		} else if (type.equals("css")) {
			element = this.driver.findElement(By.cssSelector(locator));			
		} else if (type.equals("link")) {
			element = this.driver.findElement(By.linkText(locator));
		} else if (type.equals("tag")) {
			element = this.driver.findElement(By.tagName(locator));			
		} else {
			System.out.println("Locator " + locator + " not supported");
			element = null;
		}
		
		if (element.equals(null)) {
			System.out.println("Element not found with " + type + locator);
		} else {
			System.out.println("Element found with " + type + locator);
		}
		
		return element;
	}
	
	public List<WebElement> getElements(String locator, String type) {
		type = type.toLowerCase();
		List<WebElement> elementList = new ArrayList<WebElement>();
		if (type.equals("id")) {
			elementList = this.driver.findElements(By.id(locator));
		} else if (type.equals("xpath")) {
			elementList = this.driver.findElements(By.xpath(locator));			
		} else if (type.equals("name")) {
			elementList = this.driver.findElements(By.name(locator));			
		} else if (type.equals("css")) {
			elementList = this.driver.findElements(By.cssSelector(locator));			
		} else if (type.equals("link")) {
			elementList = this.driver.findElements(By.linkText(locator));
		} else if (type.equals("tag")) {
			elementList = this.driver.findElements(By.tagName(locator));			
		} else {
			System.out.println("Locator " + locator + " not supported");
		}
		
		if (elementList.isEmpty()) {
			System.out.println("Element not found with " + type + ": " + locator);
		} else {
			System.out.println("Element found with " + type + ": " + locator);
		}
		
		return elementList;
	}
	
	public boolean isElementPresent(String locator, String type) {
		List<WebElement> elList = getElements(locator, type);
		int size = elList.size();
		if (size > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public WebElement waitForElement(By locator, int timeout) {
		WebElement el = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			el = wait.until(
					ExpectedConditions.visibilityOfElementLocated(locator));
			
		} catch (Exception e) {
			System.out.println("Element by did not appear");
		}
		
		return el;
	}
	
	public void clickWhenReady(By locator, int timeout) {
		try {
			WebElement el = null;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			el = wait.until(
					ExpectedConditions.elementToBeClickable(locator));
			el.click();
		} catch (Exception e) {
			System.out.println("Element by did not appear");
		}
	}
	
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "qazwsxedcrfvtgbyhnujmikolp123456789";
		for (int i = 0; i < length; i++) {
			int index = (int)(Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		
		return sb.toString();
	}
}
