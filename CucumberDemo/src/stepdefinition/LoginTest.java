package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
	static WebDriver driver;
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() {
		driver = new ChromeDriver();
		String baseURL = "http://www.letskodeit.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
	}

	@When("^User enters Username and Password$")
	public void user_enters_Username_and_Password() {
		driver.findElement(By.xpath("//a[@href='/login']")).click();

		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("test@email.com");

		WebElement passwd = driver.findElement(By.id("login-password"));
		passwd.clear();
		passwd.sendKeys("abcabc");
	}

	@When("^Clicks Go button$")
	public void clicks_Go_button() throws InterruptedException {
		driver.findElement(By.id("login")).click();	
		Thread.sleep(3000);
	}

	@Then("^He can visit the home page$")
	public void he_can_visit_the_practice_page() {
		WebElement home = driver.findElement(By.xpath("//a[@href='/home']"));
		home.click();
	}

	@Then("^A message is displayed$")
	public void a_message_is_displayed() {
		System.out.println("Login Successful");
	}
}
