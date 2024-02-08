package browserprofiles;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class ProfilesDemo {
	
	public static void useFxProfile() {
		// Firefox
		String baseUrl = "https://www.letskodeit.com/practice";
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fxProfile = profile.getProfile("automation");
		FirefoxOptions fxOptions = new FirefoxOptions();
		fxOptions.setProfile(fxProfile);

		WebDriver driver = new FirefoxDriver(fxOptions);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	public static void useChromeOptions() {
		// Chrome
		String baseUrl = "https://www.letskodeit.com/practice";
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\Masha\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\bkdgflcldnnnapblkhphbgpggdiikppg\\2023.12.6_0.crx"));	

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	public static void main(String[] args) {		
		useChromeOptions();
	}
 
}
