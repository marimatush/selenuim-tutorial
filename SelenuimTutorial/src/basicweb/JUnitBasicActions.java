package basicweb;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitBasicActions {
	private WebDriver driver;
	private String baseUrl;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		
		baseUrl = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void testSendKeysJs() throws InterruptedException {
//		driver.get(baseUrl);
		js.executeScript("window.location = 'https://www.letskodeit.com/practice';");
		
//		WebElement el = driver.findElement(By.id("name"));
		WebElement el = (WebElement) js.executeScript("return document.getElementById('name');");
		el.sendKeys("Hello!");
	}

	@Test
	public void testGetWindowSize() throws InterruptedException {
		js.executeScript("window.location = 'https://www.letskodeit.com/practice';");
		
		long height = (Long) js.executeScript("return window.innerHeight;");
		long width = (Long) js.executeScript("return window.innerWidth;");
		
		System.out.println("Window height is: " + height);
		System.out.println("Window width is: " + width);
	}
	
	@Test
	public void testScrollPage() throws InterruptedException {
		js.executeScript("window.location = 'https://mashaclimbing.xyz/';");
		
		// Scroll down
		js.executeScript("window.scrollBy(0, 1600);");
		Thread.sleep(2000);
		
		// Scroll up
		js.executeScript("window.scrollBy(0, -1600);");
		Thread.sleep(2000);
		
		WebElement el = driver.findElement(By.className("author-item"));
		js.executeScript("arguments[0].scrollIntoView(true);", el);
		Thread.sleep(2000);
	}
	
	@Test
	public void testClickJs() throws InterruptedException {
		js.executeScript("window.location = 'https://www.letskodeit.com/practice';");
		
		WebElement el = (WebElement) js.executeScript("return document.getElementById('hide-textbox');");
		js.executeScript("arguments[0].click();", el);
	}
}
