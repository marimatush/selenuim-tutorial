package basicweb;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTestClass {

	public static void main(String[] args) throws InterruptedException {
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Masha\\llibs\\drivers\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//		String baseURL = "http://learn.letskodeit.com";
//		driver.get(baseURL);
		String baseURL = "https://www.letskodeit.com/practice";
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		//driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
//		driver.findElement(By.id("email")).sendKeys("hello@me.com");
//		driver.findElement(By.name("enter-name")).sendKeys("Hello!");
		driver.findElement(By.cssSelector("fieldset>input#name")).sendKeys("Found!");
		Thread.sleep(3000);
		driver.close();
	}
}
