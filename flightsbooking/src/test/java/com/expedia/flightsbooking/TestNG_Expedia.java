package com.expedia.flightsbooking;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.classes.SearchPage;
import page.classes.SearchPageFactory;


public class TestNG_Expedia {
	private WebDriver driver;
	private String baseUrl;
	static Logger log = LogManager.getLogger(TestNG_Expedia.class);
	private SearchPageFactory searchPageFactory;

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		baseUrl = "https://www.expedia.com/";
		searchPageFactory = new SearchPageFactory(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(baseUrl);
	}

	@Test
	public void fillBasicInfo() throws Exception {
		SearchPage.destinationInput(driver).sendKeys("Berlin");
		SearchPage.clickSearchButton(driver);
	}
	
	@Test
	public void testSetDestinations() {
		searchPageFactory.clickFlightsTab();
		searchPageFactory.setLeavingFromInput("Paris");
		searchPageFactory.setGoingToInput("Rome");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
