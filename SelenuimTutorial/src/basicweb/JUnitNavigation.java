package basicweb;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitNavigation {
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.letskodeit.com/home";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		
		String url = driver.getCurrentUrl();
		System.out.println("Current url: " + url);
		
		String urlToNavigate = "https://www.letskodeit.com/login";
		driver.navigate().to(urlToNavigate);
		url = driver.getCurrentUrl();
		System.out.println("Navigate to: " + url);
		Thread.sleep(2000);
		
		driver.navigate().back();
		url = driver.getCurrentUrl();
		System.out.println("Navigate back: " + url);
		Thread.sleep(2000);
		
		driver.navigate().forward();
		url = driver.getCurrentUrl();
		System.out.println("Navigate forward: " + url);
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		driver.get(urlToNavigate);
	}
}
