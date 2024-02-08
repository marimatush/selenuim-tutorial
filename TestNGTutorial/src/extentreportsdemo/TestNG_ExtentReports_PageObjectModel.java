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

public class TestNG_ExtentReports_PageObjectModel {
	
	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	ExtentTest test;
	HomePage hp;

	@BeforeClass
	public void beforeClass() {
		baseUrl = "http://www.letskodeit.com/";
		report = ExtentReportsFactory.getInstance();
		
		test = report.startTest("Verify Welcome Text");
		driver = new FirefoxDriver();
		hp = new HomePage(driver, test);
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
		hp.clickSignUpLink();
		
		hp.enterLoginEmail("test@email.com");
		hp.enterLoginPasswd("abcabc");
		
		hp.clickLoginBtn();
		hp.assertAccountElement();
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
}