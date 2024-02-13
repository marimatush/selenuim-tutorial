package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLoginTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		String baseUrl = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[@href='/login']")).click();

		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("test@email.com");

		WebElement passwd = driver.findElement(By.id("login-password"));
		passwd.clear();
		passwd.sendKeys("abcabc");

		driver.findElement(By.id("login")).click();
		
		Thread.sleep(3000);
		WebElement home = driver.findElement(By.xpath("//a[@href='/home']"));
		home.click();
		System.out.println("Login successful!");
		driver.quit();
	}
}
