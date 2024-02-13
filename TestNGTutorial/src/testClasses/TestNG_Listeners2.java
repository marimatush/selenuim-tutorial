package testClasses;

import org.junit.Assert;
import org.testng.annotations.AfterClass;

//import listeners.CustomListener2;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//@Listeners(CustomListener2.class)
public class TestNG_Listeners2 {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Running beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Running afterClass");
	}

	@Test
	public void method1() {
		System.out.println("Running test method1");
		Assert.assertTrue(true);
	}
	
	@Test
	public void method2() {
		System.out.println("Running test method2");
		Assert.assertTrue(false);
	}
}
