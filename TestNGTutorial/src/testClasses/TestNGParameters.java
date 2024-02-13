package testClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appcode.SomeCLassToTest;

public class TestNGParameters {
	
	@BeforeClass
	// For example to define webdriver: chrome, firefox, ect
	@Parameters({"browser", "platform"})
	public void setup(String browser, String platform) {
		System.out.println("TestNGParameters - Setup");
		System.out.println("1. parameter value from xml file: " + browser);
		System.out.println("2. parameter value from xml file: " + platform);
	}

	@Test
	@Parameters({"response"})
	public void testSum(String response) {
		String[] stringArray = response.split(","); // to manipulate data
		System.out.println("Response from xml file: " + response);
		System.out.println("Array value 0: " + stringArray[0]);
		System.out.println("Array value 1: " + stringArray[1]);
		SomeCLassToTest s = new SomeCLassToTest();
		int res = s.sumNumber(10, -39);
		Assert.assertEquals(res, -29);
	}
	
	@Test
	public void testAddString() throws Exception {
		SomeCLassToTest s = new SomeCLassToTest();
		Thread.sleep(101);
		String expectedRes = "Hello TestNG!";
		String res = s.addString("Hello", "TestNG!");
		Assert.assertEquals(res, expectedRes);
	}
}
