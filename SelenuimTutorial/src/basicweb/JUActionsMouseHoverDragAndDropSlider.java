package basicweb;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JUActionsMouseHoverDragAndDropSlider {
	private WebDriver driver;
	private String baseUrl;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		
		baseUrl = "https://www.letskodeit.com/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testHoverOver() throws Exception {
		driver.get(baseUrl);
		js.executeScript("window.scrollBy(0, 600)");
		WebElement hoverButton = driver.findElement(By.id("mousehover"));
		Actions action = new Actions(driver);
		action.moveToElement(hoverButton).perform();
		Thread.sleep(2000);
		
		WebElement el = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[@href='#top']"));
		action.moveToElement(el).click().perform();
	}

	@Test
	public void testDragDrop() throws Exception {
		String jqueryUrl = "https://jqueryui.com/droppable/";
		driver.get(jqueryUrl);
		driver.switchTo().frame(0);
		
		WebElement fromEl = driver.findElement(By.id("draggable"));
		WebElement toEl = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		
		// drag and drop
//		action.dragAndDrop(fromEl, toEl).build().perform();
//		Thread.sleep(2000);
		
		// manual (click and hold and move)
		action.clickAndHold(fromEl).moveToElement(toEl).release().build().perform();
		
	}
	
	@Test
	public void testSlider() throws Exception {
		String jqueryUrl = "https://jqueryui.com/slider/";
		driver.get(jqueryUrl);
		driver.switchTo().frame(0);
		
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 100, 0).perform();		
	}

}
