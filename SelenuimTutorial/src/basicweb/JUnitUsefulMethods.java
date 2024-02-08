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

public class JUnitUsefulMethods {
	private WebDriver driver;
	private String baseUrl;
	private GenericMethods gm;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		gm = new GenericMethods(driver);
		
		baseUrl = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseUrl);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testGetText() {
		WebElement myElement = driver.findElement(By.id("opentab"));
		String elementText = myElement.getText();
		System.out.println("Text on the element is: " + elementText);
	}
	
	@Test
	public void testGetElementAttributeValue() {
		WebElement el = gm.getElement("name", "id");
		String attr = el.getAttribute("placeholder");
		System.out.println("Attribute value: " + attr);
	}
	
	@Test
	public void testGetElements() {
		List<WebElement> els = gm.getElements("//input[@type='text']", "xpath");
		int i = 0;
		for (WebElement el: els) {
			System.out.println("Element " + i + " - " + el.getAccessibleName());
			i++;
		}
	}
	
	@Test
	public void testElementPresent() {
		boolean result = gm.isElementPresent("name", "id");
		System.out.println("Print result: " + result);
		
		result = gm.isElementPresent("masha", "id");
		System.out.println("Print result: " + result);
	}

}
