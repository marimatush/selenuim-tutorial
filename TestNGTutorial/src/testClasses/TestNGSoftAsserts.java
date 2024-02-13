package testClasses;

import org.testng.annotations.Test;
//import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import appcode.SomeCLassToTest;

public class TestNGSoftAsserts extends base.BaseTestSuite {
	@Test
	public void testSum() {
		SoftAssert sa = new SoftAssert();
		SomeCLassToTest s = new SomeCLassToTest();
		int res = s.sumNumber(1, 2);
//		sa.assertEquals(res, 33);
		sa.assertEquals(res, 3);
		sa.assertAll(); // magic!
	}
}

