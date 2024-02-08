package keypress;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JUKeyPress {
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		
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
	public void testEnter() {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		driver.findElement(By.id("email")).sendKeys("masha@test.xyz");
		driver.findElement(By.id("login-password")).sendKeys("123");
		
		driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
		
	}
	
	@Test
	public void testTab() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		driver.findElement(By.id("email")).sendKeys("masha@test.xyz");
		driver.findElement(By.id("email")).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		driver.findElement(By.id("login-password")).sendKeys("123");
		
		driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
		
	}

	@Test
	public void testKeysCombo() throws Exception {
		driver.get(baseUrl);
//		driver.findElement(By.id("openwindow")).sendKeys(Keys.CONTROL + "a");
		String selectAll = Keys.chord(Keys.CONTROL, "a");
		driver.findElement(By.id("openwindow")).sendKeys(selectAll);
	}
	
	@Test
	public void testKeysWithActions() throws Exception {
		driver.get(baseUrl);
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
	}

}
