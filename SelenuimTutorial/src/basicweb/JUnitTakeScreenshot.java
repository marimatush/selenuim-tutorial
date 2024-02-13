package basicweb;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitTakeScreenshot {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://mashaclimbing.xyz/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@After
	public void tearDown() throws Exception {
		String fileName = getRandomString(10) + ".png";
		String dir = System.getProperty("user.dir") + "//screenshots//";
		File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourcefile, new File(dir + fileName));
		
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void testTakeScreenshot() throws InterruptedException {
		driver.get(baseUrl);
		String navigateUrl = baseUrl + "travel/";
		driver.navigate().to(navigateUrl);
		String url = driver.getCurrentUrl();
		System.out.println("Current url: " + url);
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
