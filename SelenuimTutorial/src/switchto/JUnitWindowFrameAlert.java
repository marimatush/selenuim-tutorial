package switchto;

import java.time.Duration;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitWindowFrameAlert {
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseUrl);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void testOpenWindow() throws Exception {
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent handle: " + parentWindowHandle);
		
		WebElement el = driver.findElement(By.id("openwindow"));
		el.click();
		
		// switch to a child window
		Set<String> windowHandles = driver.getWindowHandles();
		for (String h: windowHandles) {
			if (!h.equals(parentWindowHandle)) {
				String childWindowHandle = h;
				System.out.println("Child handle : " + childWindowHandle);
				driver.switchTo().window(childWindowHandle);
				WebElement searchCourses = driver.findElement(By.xpath("//input[@id='search']"));
				searchCourses.sendKeys("python");
				
				driver.close(); // close the current window
				break;
			}
		}
		
		// switch back to the parent window
		driver.switchTo().window(parentWindowHandle);
		WebElement el1 = driver.findElement(By.id("name"));
		el1.sendKeys("Leeloo");
		
	}

	@Test
	public void testSwitchFrame() throws Exception {
		WebElement iFrame = driver.findElement(By.id("courses-iframe"));
		driver.switchTo().frame(iFrame);
		
//		Also possible by id or name of iFrame
//		driver.switchTo().frame("courses-iframe"); // by id => most common 
//		driver.switchTo().frame("iframe-name"); // by name
//		driver.switchTo().frame(0); // by frame number
		
		WebElement courses = driver.findElement(By.xpath("//input[@id='search']"));
		courses.sendKeys("Leeloo");
		
		driver.switchTo().defaultContent();
		
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("Masha");
	}
	
	@Test
	public void testAlert() {
		driver.findElement(By.id("alertbtn")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@Test
	public void testConfirm() {
		driver.findElement(By.id("confirmbtn")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
