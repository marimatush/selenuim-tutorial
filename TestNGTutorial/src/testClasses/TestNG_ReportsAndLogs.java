package testClasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.junit.Assert;
import org.testng.Reporter;

public class TestNG_ReportsAndLogs {

	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("TestNG_ReportsAndLogs -> before method", true);
		
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("TestNG_ReportsAndLogs -> after method", true);
	}

	@BeforeClass
	public void beforeClass() {
		Reporter.log("TestNG_ReportsAndLogs -> before class", true);
	}

	@AfterClass
	public void afterClass() {
		Reporter.log("TestNG_ReportsAndLogs -> after class", true);
	}

	@Test
	public void testSucess() {
		Reporter.log("testSuccess", true);
	}
	
	@Test
	public void testFailure() {
		Reporter.log("testFailure", true);
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods = { "testFailure" })
	public void testSkip() {
		Reporter.log("testSkip", true);
	}
}
