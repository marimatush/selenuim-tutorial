package testClasses;

import org.testng.annotations.Test;

import appcode.SomeCLassToTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestNGParallel2{
	
	@BeforeClass
	public void setup() {		
	}
	
	@AfterClass
	public void cleanup() {
	}

	@Test
	public void testParallel1() throws InterruptedException {
		System.out.println("TestNGParallel2 -> testParallel1");
		Thread.sleep(3000);
		System.out.println("TestNGParallel2 -> testParallel1 -> more steps");
	}
	
	@Test
	public void testParallel2() throws Exception {
		System.out.println("TestNGParallel2 -> testParallel2");
		Thread.sleep(3000);
		System.out.println("TestNGParallel2 -> testParallel2 -> more steps");
	}
}
