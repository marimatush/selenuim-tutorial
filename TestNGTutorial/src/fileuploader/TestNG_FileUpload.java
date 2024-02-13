package fileuploader;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_FileUpload {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeClass
	public void beforeClass() {
		baseUrl = "https://www.ilovepdf.com/pdf_to_jpg";
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.get(baseUrl);
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void testUploadFile() throws AWTException {
		driver.findElement(By.id("pickfiles")).click();
		
		String filePath = System.getProperty("user.dir") + "\\utils\\" + "sample.pdf";
		System.out.println("File path: " + filePath);
		StringSelection ss = new StringSelection(filePath);
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, ss);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, ss);
		
		// Ctrl + V press and release
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		// Hit Enter key
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
}
