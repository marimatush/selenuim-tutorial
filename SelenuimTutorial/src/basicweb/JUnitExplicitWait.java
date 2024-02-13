package basicweb;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JUnitExplicitWait {
	WebDriver driver;
	String baseUrl;
	GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		gm = new GenericMethods(driver);
		baseUrl = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void testExplicitWait() {
		driver.get(baseUrl);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		WebElement el = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));
		el.click();
		driver.findElement(By.id("email")).sendKeys("hello@gmail.com");
	}
	
	@Test
	public void testWaitWithUtility() {
		driver.get(baseUrl);
		WebElement el = gm.waitForElement(By.xpath("//a[@href='/login']"), 3);
		el.click();
		driver.findElement(By.id("email")).sendKeys("hello@gmail.com");
	}	
	
	@Test
	public void testClickWhenReady() {
		driver.get(baseUrl);
		gm.clickWhenReady(By.id("openwindow"), 3);
	}	

}
