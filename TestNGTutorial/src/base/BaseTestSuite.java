package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTestSuite {

	@BeforeClass
	public void beforeClass() {
		System.out.println("  ==> I will be printed once before every class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("  <== I will be printed once after after class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println(" => I will be printed once before every test tag !!");
	}

	@AfterTest
	public void afterTest() {
		System.out.println(" <= I will be printed once after every test tag class !!");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("*** I will be printed once before everything ***");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("*** I will be printed once after everything ***");
	}

}
