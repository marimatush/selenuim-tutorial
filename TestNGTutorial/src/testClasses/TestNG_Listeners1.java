package testClasses;

import org.testng.annotations.Test;

//import listeners.CustomListener1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.junit.Assert;
import org.testng.annotations.AfterClass;

//@Listeners(CustomListener1.class)
public class TestNG_Listeners1 {

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
