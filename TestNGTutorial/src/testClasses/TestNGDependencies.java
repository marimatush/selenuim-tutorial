package testClasses;

import org.testng.Assert;
import appcode.SomeCLassToTest;

import org.testng.annotations.BeforeClass;
//import org.testng.Assert;
import org.testng.annotations.Test;

import appcode.SomeCLassToTest;

public class TestNGDependencies {
	SomeCLassToTest my;
	
	@BeforeClass
	public void setup() {
		my = new SomeCLassToTest();
	}
		
	@Test(dependsOnMethods= {"testTwo"}, alwaysRun=true) 
	public void testOne() {
		// it will be skipped if testTwo fails
		// if I set alwaysRun=true, the it will be always executed, even if testTwo fails
		System.out.println("Test number one");
	}
	
	@Test
	public void testTwo() {
		System.out.println("Test number two");
		int res = my.sumNumber(1, 2);
		Assert.assertEquals(13, res);
	}
	
	@Test
	public void testThree() {
		System.out.println("Test number three");
	}
}
