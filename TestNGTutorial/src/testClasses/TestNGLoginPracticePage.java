package testClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGLoginPracticePage {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeClass
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		switch(browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			driver = new ChromeDriver();
		}
		
		baseUrl = "https://www.letskodeit.com/practice";
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
