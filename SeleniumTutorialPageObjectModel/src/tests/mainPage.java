package tests;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.classes.SearchPage;

public class mainPage {
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.expedia.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseUrl);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void test() {
		SearchPage.destinationInput(driver).sendKeys("BER");
		SearchPage.clickSearchButton(driver);
	}

}
