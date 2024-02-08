package testClasses;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
//import org.testng.Assert;
import org.testng.annotations.Test;

import appcode.SomeCLassToTest;

public class TestNGPriorities {
		
	@Test(priority=1)
	public void testOne() {
		System.out.println("Test number one");
	}
	
	@Test(priority=2)
	public void testTwo() {
		System.out.println("Test number two");
	}
	
	@Test(priority=0)	// 0 - first priority
	public void testThree() {
		System.out.println("Test number three");
	}
}
