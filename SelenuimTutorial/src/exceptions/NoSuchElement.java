package exceptions;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import basicweb.GenericMethods;

public class NoSuchElement {
	private WebDriver driver;
	private String baseUrl;
	private JavascriptExecutor js;
	private GenericMethods gm;
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		gm = new GenericMethods(driver);
		
		
		baseUrl = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void testExceptionTiming() {
		driver.get(baseUrl);
		
		// Timing issue - use implicit wait or explicit wait
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		email.sendKeys("Hello!");
		
		// Incorrect locator / locator type
//		driver.findElement(By.xpath("//a[@href='/loginnnnn']")).click();		
	}

	@Test
	public void testExceptionIFrame() {
		driver.get(baseUrl);
		
		js.executeScript("window.scrollBy(0, 600);");
		driver.switchTo().frame("courses-iframe");
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("java");
		driver.switchTo().defaultContent();	
		
	}
	
	@Test
	public void testElementNotClickablePreloader() {
		// another element is overlapping this element
		driver.get("https://freecrm.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		// 1) wait for preloader to finish <-- preferred way!
		boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader-name")));
		if (invisible) {
			driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com']")).click();
			WebElement name = gm.waitForElement(By.name("email"), 3);
			name.sendKeys("Hello!");			
		}
		
		// 2) use JS executor
		WebElement login = driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com']"));
		js.executeScript("arguments[0].click();", login);
	}
	
	@Test
	public void testStaleElement() {
		// Stale - not fresh; element has become stale
		driver.get(baseUrl);
//		WebElement check = driver.findElement(By.id("bmwcheck")); -> will cause StaleElementException
		// if DOM has been regenerated (page reloader)
		driver.get(driver.getCurrentUrl());
		// find element when you need it!
		WebElement check = driver.findElement(By.id("bmwcheck"));
		check.click();
		
	}
	
	@Test
	public void testElementIsNotInteractable() {
		// Element is present in DOM, but it is not in the view (need to scroll)
		// Element is overlapped by another, but ususally you'll get NotClickabel exeption
		
		// Element is hidden or disabled
		// Performing unsupported action on the element
		
		driver.get("https://www.letskodeit.com/login");
//		driver.findElement(By.xpath("//form[@name='loginform']")).click();
//		driver.findElement(By.xpath("//form[@name='loginform']")).sendKeys("sss");
		driver.findElement(By.id("search")).sendKeys("masha"); // won't work
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("masha"); // will work

		
	}
	
	@Test
	public void testElementIsNotInteractableExpedia() {
		driver.get("https://www.expedia.com/");
		driver.findElement(By.xpath("//a[@aria-controls='search_form_product_selector_flights']")).click();
		driver.findElement(By.xpath("//button[@data-stid='origin_select-menu-trigger']")).click();
		driver.findElement(By.id("origin_select")).sendKeys("ABC");
	}
}
