package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SelenuimManagementDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Masha\\llibs\\drivers\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//		String baseURL = "http://learn.letskodeit.com";
//		driver.get(baseURL);
		WebDriver driver = new FirefoxDriver();
		String baseURL = "http://learn.letskodeit.com";
		driver.get(baseURL);
	}
}
