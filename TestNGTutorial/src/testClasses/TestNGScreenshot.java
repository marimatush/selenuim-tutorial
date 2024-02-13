package testClasses;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGScreenshot {
	
	WebDriver driver;
	String baseUrl;
	
	@BeforeMethod
	public void setup() {
		baseUrl = "https://www.facebook.com/";
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseUrl);
	}
	
	@Test
	public void testMethod1() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("test-email");
		driver.findElement(By.id("pass")).sendKeys("test-pass");
		driver.findElement(By.id("Login")).click();	// intentional failure
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println("Test failed: " + testResult.getMethod().getMethodName());
			String filename = getRandomString(10) + ".png";
			String dir = System.getProperty("user.dir") + "/screenshots/";
			File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourcefile, new File(dir + filename));
		}
		driver.quit();
	}
	
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
