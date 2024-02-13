package testClasses;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Constants;
import base.ExcelUtility;

public class TestNG_UsingExcel {
	private WebDriver driver;

	@BeforeClass
	public void beforeClass() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(Constants.URL);
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		
		// Location of Excel file
		ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "LoginTests");
	}

	@DataProvider(name = "LoginData")
	public Object[][] dataProvider() {
		Object[][] testData = ExcelUtility.getTestData("Invalid_Login");
		return testData;
	}
	
	@Test(dataProvider="LoginData")
	public void testLogin(String username, String password) throws Exception {
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys(username);
		
		WebElement passwd = driver.findElement(By.id("login-password"));
		passwd.clear();
		passwd.sendKeys(password);
		Thread.sleep(2000);
		
		driver.findElement(By.id("login")).click();
		
		WebElement errorLogin = driver.findElement(By.id("incorrectdetails"));
		Assert.assertNotEquals(errorLogin, null);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
