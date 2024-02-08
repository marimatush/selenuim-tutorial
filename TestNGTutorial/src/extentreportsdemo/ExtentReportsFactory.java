package extentreportsdemo;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportsFactory {
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String Path = System.getProperty("user.dir") + "/extentreports/" + "/extentreports.html";
		extent = new ExtentReports(Path, true);	// false: do not override existing report
		extent
	     .addSystemInfo("Selenium Version", "4.16")
	     .addSystemInfo("Platform", "Windows");

		return extent;
	}
}