package testClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.HandleEvents;

public class TestNG_WebDriverEventListeners {
	private WebDriver driver;
	private String baseUrl;
	private HandleEvents he;
	private EventFiringWebDriver eDriver;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		baseUrl = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		eDriver = new EventFiringWebDriver(driver);
		he = new HandleEvents();
		eDriver.register(he);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testListeners() {
		eDriver.get(baseUrl);
		eDriver.findElement(By.id("hide-textbox")).click();
		
		eDriver.navigate().to("https://www.letskodeit.com/blog");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
