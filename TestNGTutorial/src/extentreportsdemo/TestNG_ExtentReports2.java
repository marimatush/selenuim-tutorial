package extentreportsdemo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.Screenshots;

public class TestNG_ExtentReports2 {
	
	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void beforeClass() {
		baseUrl = "http://www.letskodeit.com/";
		report = ExtentReportsFactory.getInstance();
		
		test = report.startTest("Verify Welcome Text");
		driver = new FirefoxDriver();
		test.log(LogStatus.INFO, "Browser Started...");

		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser Maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Web application opened");
	}
	
	@Test
	public void test1_validLoginTest() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[@href='/login']")).click(); ////a[@href="/login"]
		test.log(LogStatus.INFO, "Clicked on login link");
		
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("test@email.com");
		test.log(LogStatus.INFO, "Enter email");
		
		WebElement passwd = driver.findElement(By.id("login-password"));
		passwd.clear();
		passwd.sendKeys("abcabcD");	// intentional failure
		test.log(LogStatus.INFO, "Enter password");
		
		driver.findElement(By.id("login")).click();
		test.log(LogStatus.INFO, "Clicked Login button");

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
	
	
	@AfterMethod
	public void afterMethod(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(driver, testResult.getName());
			String imgPath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Verify Login failed", imgPath);
		}
		driver.quit();
		report.endTest(test); 
		report.flush();
	}
	
//	@AfterClass
//	public void afterClass() throws InterruptedException {
//		Thread.sleep(3000);
//		driver.quit();
//		report.endTest(test); 
//		report.flush();
//	}
	
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "qazwsxedcrfvtgbyhnujmikolp123456789";
		for (int i = 0; i < length; i++) {
			int index = (int)(Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		
		return sb.toString();
	}
}