package testClasses;

import org.testng.annotations.Test;

import appcode.SomeCLassToTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestNGTestTimeout extends base.BaseTestSuite {
	
	@BeforeClass
	public void setup() {		
	}
	
	@AfterClass
	public void cleanup() {
	}

	@Test(enabled=false)
	public void testSum() {
		SomeCLassToTest s = new SomeCLassToTest();
		int res = s.sumNumber(10, -39);
		Assert.assertEquals(res, -29);
	}
	
	@Test(timeOut=110) // if it doesn't finish in the given time, fail it
	public void testAddString() throws Exception {
		SomeCLassToTest s = new SomeCLassToTest();
		Thread.sleep(101);
		String expectedRes = "Hello TestNG!";
		String res = s.addString("Hello", "TestNG!");
		Assert.assertEquals(res, expectedRes);
	}
}
