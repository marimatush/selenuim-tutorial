package basicweb;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitCalendarSelection {
	private WebDriver driver;
	private String baseUrl;
	private GenericMethods gm;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		gm = new GenericMethods(driver);
		baseUrl = "https://www.expedia.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void testOpenCalendarByDate() throws Exception {
		driver.get(baseUrl);
		gm.clickWhenReady(By.xpath("//button[@data-stid='uitk-date-selector-input1-default']"), 3);
		
		gm.clickWhenReady(
				By.xpath("//section[@data-testid='popover-sheet']//div[@class='uitk-month uitk-month-double uitk-month-double-left']//td[@class='uitk-day']//div[text()='23']"),
				3);
	}

	@Test
	public void testOpenCalendarFirstAvailableDate() throws Exception {
		driver.get(baseUrl);
		gm.clickWhenReady(By.xpath("//button[@data-stid='uitk-date-selector-input1-default']"), 3);
		WebElement cal = gm.getElement(
				"//section[@data-testid='popover-sheet']//div[@class='uitk-month uitk-month-double uitk-month-double-left']","xpath");
		

		List<WebElement> allValidDates = cal.findElements(By.xpath("//div[@aria-disabled='false']"));
		for (WebElement date: allValidDates) {
			if (date.getText().equals("30")) {
				System.out.println("Date found");
				date.click();
				break;
			}
		}
		Thread.sleep(3000);
	}
}
