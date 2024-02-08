package extentreportsdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {
	WebDriver driver = null;
	ExtentTest test;
	
	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public void clickSignUpLink() {
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		test.log(LogStatus.INFO, "Clicked on login link");
	}

	public void enterLoginEmail(String emailText) {
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys(emailText);
		test.log(LogStatus.INFO, "Enter email");
	}
	
	public void enterLoginPasswd(String password) {
		WebElement passwd = driver.findElement(By.id("login-password"));
		passwd.clear();
		passwd.sendKeys(password);
		test.log(LogStatus.INFO, "Enter password");
	}
	
	public void clickLoginBtn() {
		driver.findElement(By.id("login")).click();
		test.log(LogStatus.INFO, "Clicked Login button");
	}
	
	public void assertAccountElement() {
		WebElement welcomeText = null;
		try {
			welcomeText = driver.findElement(By.xpath("//span[text()='My Account']"));
		}
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertTrue(welcomeText != null);
		test.log(LogStatus.PASS, "Verified Welcome Text");
	}
}
