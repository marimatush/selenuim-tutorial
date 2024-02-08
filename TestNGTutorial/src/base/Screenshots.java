package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
		fileName = fileName + ".png";
		String dir = System.getProperty("user.dir") + "/screenshots/";
		File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = dir + fileName;  
		FileUtils.copyFile(sourcefile, new File(destination));
		return destination;
	}
}
