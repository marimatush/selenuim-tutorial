package tests;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.classes.SearchPageFactory;

public class testFlightsTab {
	WebDriver driver;
	String baseUrl;
	SearchPageFactory searchPage;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		searchPage = new SearchPageFactory(driver);
		
		baseUrl = "https://www.expedia.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void testSetDestination() {
		driver.get(baseUrl);
		searchPage.clickFlightsTab();
		searchPage.setLeavingFromInput("Paris");
		searchPage.setGoingToInput("Rome");
	}

}
