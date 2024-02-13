package tests;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import page.classes.SearchPageFactory;

public class JUnitFindLinks {
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
	public void testFindLinks() {
		//driver.get("https://trustwallet.com/");
		//searchPage.clickFlightsTab();
		driver.get(baseUrl);
		
		List<WebElement> linksList = clickableLinks(driver);
		
		for (WebElement link: linksList) {
			String href = link.getAttribute("href");
			try {
				System.out.println("URL " + href + " return " + linkStatus(new URL(href)));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static List<WebElement> clickableLinks(WebDriver driver) {
		List<WebElement> linksToClink = new ArrayList<WebElement>();
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		elements.addAll(driver.findElements(By.tagName("img")));
		
		for (WebElement e: elements) {
			if (e.getAttribute("href") != null) {
				linksToClink.add(e);
			}
		}
		
		return linksToClink;
	}
	
	public static String linkStatus(URL url) {
		try {
			HttpsURLConnection http = (HttpsURLConnection) url.openConnection();
			http.connect();
			
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			
			return responseMessage;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
