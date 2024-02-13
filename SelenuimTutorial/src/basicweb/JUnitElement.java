package basicweb;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class JUnitElement {
	WebDriver driver;
	String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
//		String baseUrl = "https://www.google.com/";
		baseUrl = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void testGoogleSearch() {
		// Google search
		driver.get("https://www.google.com/");
		driver.findElement(By.id("W0wltc")).click();
		WebElement e1 = driver.findElement(By.name("q"));
		System.out.println(e1.isEnabled());
		e1.sendKeys("westie");		
	}

	@Test
	public void testRadioButtons() throws Exception {
		// Radio buttons list
		driver.get(baseUrl);
		boolean isChecked = false;
		List<WebElement> rbList = driver.findElements(By.xpath("//input[@type='radio' and @name='cars']"));
		for (int i = 0; i < rbList.size(); i++) {
			isChecked = rbList.get(i).isSelected();
			
			if(!isChecked) {
				rbList.get(i).click();
				Thread.sleep(2000);
			}
		}
	}
	
	@Test
	public void testDropdown() {
		// Drop down (select tag)
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.id("carselect"));
		Select selectElement = new Select(element);
		selectElement.selectByValue("benz");
		selectElement.selectByIndex(2);
		selectElement.selectByVisibleText("BMW");
		
		List<WebElement> optionList = selectElement.getOptions();
		int size = optionList.size();
		for(int i = 0; i < size; i ++) {
			String optionName = optionList.get(i).getText();
			System.out.println(optionName);
		}
	}
	
	@Test
	public void testMultipleSelect() {
		// Multiple Select
		driver.get(baseUrl);
		WebElement multiElement = driver.findElement(By.id("multiple-select-example"));
		Select multiSelect = new Select(multiElement);
		multiSelect.selectByValue("orange");
		multiSelect.deselectByValue("orange");
		multiSelect.selectByIndex(2);
		multiSelect.selectByVisibleText("Apple");
		List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
		for (WebElement option: selectedOptions) {
			System.out.println(option.getText());
		}
		multiSelect.deselectAll();
	}
	
	
	@Test
	public void testHiddenElement() {
		driver.get(baseUrl);
		
		// Hidden elements
		WebElement hidden = driver.findElement(By.id("displayed-text"));
		System.out.println("Text box displayed? " + hidden.isDisplayed());
		driver.findElement(By.id("hide-textbox")).click();
		System.out.println("Text box displayed? " + hidden.isDisplayed());
		driver.findElement(By.id("show-textbox")).click();
		System.out.println("Text box displayed? " + hidden.isDisplayed());		
	}
	
	@Test
	public void testExpedia() throws InterruptedException {
		driver.get("https://www.expedia.com/");
		driver.findElement(By.xpath("//button[@data-testid='header-menu-button']")).click();
		driver.findElement(By.xpath("//button[@data-stid='open-room-picker']")).click();
		WebElement childUnderOne = driver.findElement(By.id("age-traveler_selector_children_age_selector-0-0"));
		System.out.println("Text box displayed? " + childUnderOne.isDisplayed());		
	}

}
