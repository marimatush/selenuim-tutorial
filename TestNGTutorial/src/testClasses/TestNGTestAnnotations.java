package testClasses;

import org.testng.annotations.Test;

import appcode.SomeCLassToTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestNGTestAnnotations extends base.BaseTestSuite {
	
	@BeforeClass
	public void setup() {		
	}
	
	@AfterClass
	public void cleanup() {
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("   ===> I will be printed BEFORE every test method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("   <=== I will be printed AFTER every test method");
	}

	@Test
	public void testSum() {
		SomeCLassToTest s = new SomeCLassToTest();
		int res = s.sumNumber(10, -39);
		Assert.assertEquals(res, -29);
	}
	
	@Test
	public void testAddString() {
		SomeCLassToTest s = new SomeCLassToTest();
		String expectedRes = "Hello TestNG!";
		String res = s.addString("Hello", "TestNG!");
		Assert.assertEquals(res, expectedRes);
	}
}
