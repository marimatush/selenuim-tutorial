package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import appcode.SomeCLassToTest;

public class TestNGFirstDemo extends base.BaseTestSuite {
	
	@Test
	public void testMethod1() {
		System.out.println("Hello TestNG!");
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
	
	@Test
	public void testArray() {
		SomeCLassToTest s = new SomeCLassToTest();
		int[] expectedArray = {1, 2, 3};
		int[] res = s.getArray();
		Assert.assertEquals(res, expectedArray);
	}
}
