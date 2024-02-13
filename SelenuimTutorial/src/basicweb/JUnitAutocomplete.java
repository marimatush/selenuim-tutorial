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

public class JUnitAutocomplete {
	WebDriver driver;
	String baseUrl;
	GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		gm = new GenericMethods(driver);
		baseUrl = "https://www.expedia.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseUrl);
	}

	@After
	public void tearDown() throws Exception {
//		Thread.sleep(3000);
//		driver.quit();
	}

	@Test
	public void testAutocomplete() {
		String partialText = "Ber";
		String textToSelect = "Berlin Germany";
		
		WebElement destinationBtn = driver.findElement(By.xpath("//button[@data-stid='destination_form_field-menu-trigger']"));
		destinationBtn.click();
		
		WebElement destinationInput = driver.findElement(By.xpath("//input[@data-stid='destination_form_field-menu-input']"));
		destinationInput.sendKeys(partialText);
		
		WebElement ulEl = driver.findElement(By.xpath("//ul[@data-stid='destination_form_field-results']"));
		String innerHTML = ulEl.getAttribute("innerHTML");
		
		//System.out.println(innerHTML);
		gm.waitForElement(By.xpath("//li[@data-stid='destination_form_field-result-item']"), 10);
		List<WebElement> liEls = ulEl.findElements(By.tagName("li"));
		
		// It doesn't work due protection from bots
		for (WebElement el: liEls) {
			if (el.getText().contains(textToSelect)) {
				System.out.println("Selected element: " + el.getText());
				break; // if we comment it out, the element will turn stale
				// If previously found element does not exist in DOM, don't try to find it!
			}
		}
		
	}

}
