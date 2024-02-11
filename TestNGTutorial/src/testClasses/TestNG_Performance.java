package testClasses;

import org.testng.annotations.Test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;	
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import base.Constants;
import base.ExcelUtility;

public class TestNG_Performance {
	static Logger log = LogManager.getLogger(TestNG_Performance.class);
	private long startTime;
	private long endTime;
	private long duration;
	private double seconds;

	private WebDriver driver;
	private String baseUrl;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name_Performance, "Sheet1");
	}
	
	@AfterMethod
	public void cleupTest() {
		driver.quit();
	}

	@Test
	public void testLogin() throws Exception {
		startTime = System.nanoTime();
		
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[@href='/login']")).click(); ////a[@href="/login"]
		
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("masha@practice.xyz");
		
		WebElement passwd = driver.findElement(By.id("login-password"));
		passwd.clear();
		passwd.sendKeys("123456789");
		
		driver.findElement(By.id("login")).click();

		endTime = System.nanoTime();
		duration = endTime - startTime;
		seconds = (double)duration / 1000000000.0;
		log.debug("Test took " + seconds + " seconds");
		
//		ExcelUtility.setCellData(Constants.File_Name_Performance, "login", 1, 0);
//		ExcelUtility.setCellData(Constants.File_Name_Performance, seconds, 1, 1);
	}
}
