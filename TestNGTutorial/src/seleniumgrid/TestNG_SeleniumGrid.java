package seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_SeleniumGrid {
	private WebDriver driver;
	private String baseUrl;
	private String nodeUrl;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {		
		baseUrl = "https://www.letskodeit.com/practice";
		nodeUrl = "http://192.168.56.1:4444";
		
		
		URL gridUrl = new URL("http://localhost:4444");
		driver = new RemoteWebDriver(gridUrl, new ChromeOptions());
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void cleupTest() {
		driver.quit();
	}

	@Test
	public void testLogin() {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[@href='/login']")).click(); ////a[@href="/login"]
		
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("masha@practice.xyz");
		
		WebElement passwd = driver.findElement(By.id("login-password"));
		passwd.clear();
		passwd.sendKeys("123456789");
		
		driver.findElement(By.id("login")).click();
	}
}
